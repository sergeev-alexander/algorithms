package sergeev.alexander.xml;
import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XmlStringReplacer {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java XmlStringReplacer <path_to_xml_file> <string_to_replace>");
            return;
        }

        String xmlFilePath = args[0];
        String searchString = "Какую категорию";

        try {
            // Загружаем XML файл
            File xmlFile = new File("____.xml");;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Ищем и заменяем строки
            replaceStringInNodes(doc, searchString, "Выберите категорию");

            // Сохраняем изменения в XML файл
            saveXmlFile(doc, xmlFile);

            System.out.println("Замена завершена успешно.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void replaceStringInNodes(Document doc, String searchString, String replacement) {
        NodeList nodeList = doc.getElementsByTagName("*"); // Получаем все элементы

        for (int i = 0; i < nodeList.getLength(); i++) {
            String nodeValue = nodeList.item(i).getTextContent();
            if (nodeValue.contains(searchString)) {
                String newValue = nodeValue.replace(searchString, replacement);
                nodeList.item(i).setTextContent(newValue);
            }
        }
    }

    private static void saveXmlFile(Document doc, File filePath) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(filePath);
        transformer.transform(source, result);
    }
}
