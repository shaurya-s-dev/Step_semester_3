package oop.assigment_problems;

public class InternEmployee extends Employee {
    private double stipendCap;

    public InternEmployee(int empId, String empName, double salary, double stipendCap) {
        super(empId, empName, salary);
        this.stipendCap = stipendCap;
    }

    public double effectiveSalary() {
        return Math.min(getSalary(), stipendCap);
    }

    public static void main(String[] args) {
        Employee plain = new Employee(1, "Karan", 40000);
        ManagerEmployee manager = new ManagerEmployee(2, "Divya", 70000, 8000);
        InternEmployee intern = new InternEmployee(3, "Meera", 12000, 10000);

        System.out.println("Plain employee pay: Rs " + plain.getSalary());

        if (manager instanceof ManagerEmployee) {
            System.out.println("Manager effective pay: Rs " + manager.effectiveSalary());
        }
        if (intern instanceof InternEmployee) {
            System.out.println("Intern effective pay: Rs " + intern.effectiveSalary());
        }
    }
}