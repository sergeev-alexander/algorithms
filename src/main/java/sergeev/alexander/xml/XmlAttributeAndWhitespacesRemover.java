package sergeev.alexander.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XmlAttributeAndWhitespacesRemover {

    private static final String INPUT_FILE_PATH = "input_book.xml";
    private static final String OUTPUT_FILE_PATH = "book.xml";
    private static final List<String> ATTRIBUTES_TO_REMOVE = List.of("gpt", "eng");

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(INPUT_FILE_PATH));

            Element root = document.getDocumentElement();
            removeAttributes(root);

            // УДАЛЯЕМ пробельные узлы перед сохранением
            removeWhitespaceNodes(root);

            saveDocument(document, OUTPUT_FILE_PATH);

            System.out.println("Атрибуты успешно удалены. Результат сохранен в " + OUTPUT_FILE_PATH);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void removeAttributes(Element element) {
        for (String attrName : ATTRIBUTES_TO_REMOVE) {
            if (element.hasAttribute(attrName)) {
                element.removeAttribute(attrName);
            }
        }

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                removeAttributes((Element) node);
            }
        }
    }

    // Метод для сохранения DOM-документа в файл БЕЗ отступов
    private static void saveDocument(Document document, String filePath) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(filePath));

        transformer.setOutputProperty(OutputKeys.INDENT, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

        transformer.transform(source, result);
    }

    // Рекурсивный метод для удаления пробельных текстовых узлов
    private static void removeWhitespaceNodes(Element element) {
        NodeList children = element.getChildNodes();

        for (int i = children.getLength() - 1; i >= 0; i--) {
            Node child = children.item(i);

            if (child.getNodeType() == Node.TEXT_NODE) {
                String text = child.getTextContent();
                if (text != null && text.trim().isEmpty()) {
                    element.removeChild(child);
                }
            } else if (child.getNodeType() == Node.ELEMENT_NODE) {
                removeWhitespaceNodes((Element) child);
            }
        }
    }
}
