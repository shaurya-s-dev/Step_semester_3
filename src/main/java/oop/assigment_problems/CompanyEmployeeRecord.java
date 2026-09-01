package oop.assigment_problems;

public class CompanyEmployeeRecord {
    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;

    static int totalRecords = 0;

    public CompanyEmployeeRecord(String name, String empId, Employee employee, ParkingSlot slot) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;
        totalRecords++;
    }

    public String fullProfile() {
                double pay;
        if (employee instanceof ManagerEmployee) {
            pay = ((ManagerEmployee) employee).effectiveSalary();
        } else if (employee instanceof InternEmployee) {
            pay = ((InternEmployee) employee).effectiveSalary();
        } else {
            pay = employee.getSalary();
        }

        String slotInfo = (slot != null) ? slot.getSlotNo() : "no parking assigned";
        return name + " | Pay: Rs " + pay + " | Slot: " + slotInfo;
    }

    public static void main(String[] args) {
        Employee manager = new ManagerEmployee(1, "Divya", 70000, 8000);
        Employee plain = new Employee(2, "Karan", 40000);
        Employee intern = new InternEmployee(3, "Meera", 12000, 10000);

        ParkingSlot slotA1 = new ParkingSlot("A1", 4, 0);
        ParkingSlot slotA2 = new ParkingSlot("A2", 4, 0);

        CompanyEmployeeRecord r1 = new CompanyEmployeeRecord("Divya", "E1", manager, slotA1);
        CompanyEmployeeRecord r2 = new CompanyEmployeeRecord("Karan", "E2", plain, slotA2);
        CompanyEmployeeRecord r3 = new CompanyEmployeeRecord("Meera", "E3", intern, null);

        System.out.println(r1.fullProfile());
        System.out.println(r2.fullProfile());
        System.out.println(r3.fullProfile());

        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}