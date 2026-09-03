package week3.assignment_problems;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee plain = new Employee(1, "Plain", 40000);
        ManagerEmployee mgr = new ManagerEmployee(2, "Manager", 70000, 8000);
        InternEmployee intern = new InternEmployee(3, "Intern", 12000, 10000);

        System.out.println("Plain employee pay: Rs " + plain.getSalary());
        System.out.println("Manager effective pay: Rs " + mgr.effectiveSalary());
        System.out.println("Intern effective pay: Rs " + intern.effectiveSalary());
    }
}