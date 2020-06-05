package hw1_tumilovich_auto.task1;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyDOMParser {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Document document;

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(new File("src/main/java/hw1_tumilovich_auto/task1/Employee.xml"));

        NodeList employeeElements = document.getDocumentElement().getElementsByTagName("employee");
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node employee = employeeElements.item(i);
            NamedNodeMap attributes = employee.getAttributes();
            employees.add(new Employee(attributes.getNamedItem("first_name").getNodeValue(),
                    attributes.getNamedItem("last_name").getNodeValue(),
                    attributes.getNamedItem("position").getNodeValue(),
                    attributes.getNamedItem("department").getNodeValue(),
                    Integer.parseInt(attributes.getNamedItem("record_of_service").getNodeValue())
            ));
        }
        System.out.println("DOM Parser:");
        for (Employee employee : employees) {
            System.out.printf("Employee Name: %s %s, position: %s, department: %s, record of service: %d", employee.getFirst_name(),
                    employee.getLast_name(), employee.getPosition(), employee.getDepartment(), employee.getRecord_of_service());
            System.out.println();
        }

        checkEmployee("Ivan Ivanov");
        checkEmployee("Ivan Petrov");
    }

    public static void checkEmployee(String firstName_lastName) {
        boolean found = false;
        String[] name = firstName_lastName.split(" ");
        String firstName = name[0];
        String lastName = name[1];
        NodeList employeeElements = document.getDocumentElement().getElementsByTagName("employee");

        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node employee = employeeElements.item(i);
            NamedNodeMap attributes = employee.getAttributes();
            if (firstName.equals(attributes.getNamedItem("first_name").getNodeValue()) && lastName.equals(attributes.getNamedItem("last_name").getNodeValue())) {
                found = true;
                System.out.println("\nEmployee with name " + firstName_lastName + " exists. Info:" +
                        "\nName: " + attributes.getNamedItem("first_name").getNodeValue() +
                        "\nLast Name: " + attributes.getNamedItem("last_name").getNodeValue() +
                        "\nPosition: " + attributes.getNamedItem("position").getNodeValue() +
                        "\nDepartment: " + attributes.getNamedItem("department").getNodeValue() +
                        "Record of service: " + Integer.parseInt(attributes.getNamedItem("record_of_service").getNodeValue()) + " year(s)"
                );
            }
        }
        if (!found) {
            System.out.println("\nThere is no employee with name " + firstName_lastName);
        }
    }
}
