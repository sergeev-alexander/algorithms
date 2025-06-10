package sergeev.alexander.xml_1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XmlAttributeRemover {

    private static final String INPUT_FILE_PATH = "video_full.xml";
    private static final String OUTPUT_FILE_PATH = "video.xml";
    private static final List<String> ATTRIBUTES_TO_REMOVE = List.of("gpt", "eng");

    public static void main(String[] args) {
        try {
            // Создаем парсер
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Парсим входной XML-файл
            Document document = builder.parse(new File(INPUT_FILE_PATH));

            // Получаем корневой элемент
            Element root = document.getDocumentElement();

            // Рекурсивно проходим по всем элементам и удаляем атрибуты
            removeAttributes(root);

            // Сохраняем измененный документ в новый файл
            saveDocument(document, OUTPUT_FILE_PATH);

            System.out.println("Атрибуты успешно удалены. Результат сохранен в " + OUTPUT_FILE_PATH);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Рекурсивный метод для удаления атрибутов у элемента и его дочерних элементов
    private static void removeAttributes(Element element) {
        // Удаляем указанные атрибуты у текущего элемента
        for (String attrName : ATTRIBUTES_TO_REMOVE) {
            if (element.hasAttribute(attrName)) {
                element.removeAttribute(attrName);
            }
        }

        // Рекурсивно обрабатываем дочерние элементы
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                removeAttributes((Element) node);
            }
        }
    }

    // Метод для сохранения DOM-документа в файл
    private static void saveDocument(Document document, String filePath) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(filePath));

        // Настраиваем форматирование (для читаемости)
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        transformer.transform(source, result);
    }
}