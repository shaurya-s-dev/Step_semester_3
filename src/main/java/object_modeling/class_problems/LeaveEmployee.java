package object_modeling.class_problems;

public class LeaveEmployee {
    private String name;
    private String employeeType;

    public LeaveEmployee(String name, String employeeType) {
        this.name = name;
        this.employeeType = employeeType;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeType() {
        return employeeType;
    }
}
