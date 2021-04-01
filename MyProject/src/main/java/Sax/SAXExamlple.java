package Sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.text.EditorKit;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXExamlple {
    private static boolean isFound;
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        /*XMLHandler XMLhandler = new XMLHandler();
        parser.parse(new File("/home/oleg/JavaRushTasks/MyProject/src/Sax/First.xml"), XMLhandler);
        for(Employee emp : employees)
            System.out.println(String.format("Имя сотрудника: %s, его должность: %s", emp.getName(), emp.getJob()));
        employees = null;*/

        /*AdvancedXMLHandler AdXMLhandler = new AdvancedXMLHandler();
        parser.parse(new File("/home/oleg/JavaRushTasks/MyProject/src/Sax/Second.xml"), AdXMLhandler);
        for(Employee emp : employees)
            System.out.println(String.format("Имя сотрудника: %s, его должность: %s", emp.getName(), emp.getJob()));*/

        SearchingXMLHandler handler = new SearchingXMLHandler("root");
        parser.parse(new File("/home/oleg/JavaRushTasks/MyProject/src/Sax/Thrith.xml"), handler);

        if (!isFound)
            System.out.println("Элемент не был найден.");
    }

    private  static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("employee")) {
                String name = attributes.getValue("name");
                String job = attributes.getValue("job");
                employees.add(new Employee(name, job));
            }
        }
    }

    private  static class AdvancedXMLHandler extends DefaultHandler {
        private String name, job, lastElementName;
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (((name != null) && (!name.isEmpty())) && ((job != null) && (!job.isEmpty()))) {
                employees.add(new Employee(name, job));
                name = null;
                job  = null;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);
            information = information.replaceAll("\n", "").trim();
            if (!information.isEmpty()) {
                if (lastElementName.equals("name"))
                    name = information;
                if (lastElementName.equals("job"))
                    job = information;
            }
        }
    }

    private static class SearchingXMLHandler extends DefaultHandler {
        private String element;
        private boolean isEntered;

        public SearchingXMLHandler(String element) {
            this.element = element;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (isEntered) {
                System.out.println(String.format("Найден элемент <%s>, его атрибуты:", qName));

                int length = attributes.getLength();
                for(int i = 0; i < length; i++)
                    System.out.println(String.format("Имя атрибута: %s, его значение: %s", attributes.getQName(i), attributes.getValue(i)));
            }

            if (qName.equals(element)) {
                isEntered = true;
                isFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(element))
                isEntered = false;
        }
    }
}
