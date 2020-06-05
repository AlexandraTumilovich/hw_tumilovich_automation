package hw1_tumilovich_auto.task1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MySAXParser extends DefaultHandler {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File("src/main/java/hw1_tumilovich_auto/task1/Employee.xml"), handler);
        System.out.println("SAX Parser:");
        for (Employee employee : employees) {
            System.out.printf("Employee Name: %s %s, position: %s, department: %s, record of service: %d", employee.getFirst_name(),
                    employee.getLast_name(), employee.getPosition(), employee.getDepartment(), employee.getRecord_of_service());
            System.out.println();
        }
    }

    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("employee")) {
                String first_name = attributes.getValue("first_name");
                String last_name = attributes.getValue("last_name");
                String position = attributes.getValue("position");
                String department = attributes.getValue("department");
                int record_of_service = Integer.parseInt(attributes.getValue("record_of_service"));
                employees.add(new Employee(first_name, last_name, position, department, record_of_service));
            }
        }
    }
}



