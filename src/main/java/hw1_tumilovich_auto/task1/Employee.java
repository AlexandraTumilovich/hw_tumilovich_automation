package hw1_tumilovich_auto.task1;

public class Employee {
    private String first_name;
    private String last_name;
    private String position;
    private String department;
    private int record_of_service;

    public Employee(String first_name, String last_name, String position, String department, int record_of_service) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.department = department;
        this.record_of_service = record_of_service;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRecord_of_service() {
        return record_of_service;
    }

    public void setRecord_of_service(int record_of_service) {
        this.record_of_service = record_of_service;
    }
}
