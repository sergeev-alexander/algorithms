package sergeev.alexander.xml_1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLToHierarchy {

    public static void main(String[] args) {
        try {
            // Указываем путь к XML-файлу
            File xmlFile = new File("book.xml");

            // Создаем парсер
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Создаем файл для записи результата
            File outputFile = new File("book.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            // Рекурсивно обходим XML и записываем иерархию в файл
            printNode(doc.getDocumentElement(), "", writer, true);

            // Закрываем writer
            writer.close();

            System.out.println("Иерархия успешно записана в файл book.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNode(Node node, String indent, BufferedWriter writer, boolean isLast) throws IOException {
        // Проверяем тип узла
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            String nodeName = node.getNodeName();

            // Обработка элемента question
            if (nodeName.equals("question")) {
                String type = node.getAttributes().getNamedItem("type").getNodeValue();
                String key = node.getAttributes().getNamedItem("key").getNodeValue();
                String label = node.getAttributes().getNamedItem("label").getNodeValue();

                // Записываем элемент question
                writer.write(indent + (isLast ? "└── " : "├── ") + "(?)[" + type + "] " + key + " \"" + label + "\"");
                writer.newLine();
            }

            // Обработка элемента answer
            else if (nodeName.equals("answer")) {
                String key = node.getAttributes().getNamedItem("key").getNodeValue();
                String label = node.getAttributes().getNamedItem("label").getNodeValue();

                // Записываем элемент answer
                writer.write(indent + (isLast ? "└── " : "├── ") + key + " \"" + label + "\"");
                writer.newLine();
            }

            // Рекурсивно обходим дочерние элементы
            NodeList children = node.getChildNodes();
            int childCount = 0;
            for (int i = 0; i < children.getLength(); i++) {
                if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    childCount++;
                }
            }

            int currentChild = 0;
            for (int i = 0; i < children.getLength(); i++) {
                if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    currentChild++;
                    boolean lastChild = (currentChild == childCount);
                    printNode(children.item(i), indent + (isLast ? "    " : "│   "), writer, lastChild);
                }
            }
        }
    }
}