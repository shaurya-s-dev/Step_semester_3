package week3.assignment_problems;

class CompanyEmployeeRecord {
    String name;
    String empId;
    Employee employee;      // can be Employee or ManagerEmployee
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
        double pay = 0;
        if (employee instanceof ManagerEmployee) {
            pay = ((ManagerEmployee) employee).effectiveSalary();
        } else if (employee instanceof InternEmployee) {
            pay = ((InternEmployee) employee).effectiveSalary();
        } else {
            pay = employee.getSalary();
        }
        String slotInfo = (slot == null) ? "no parking assigned" : slot.slotNo;
        return name + " | Pay: Rs " + pay + " | Slot: " + slotInfo;
    }

    public static void main(String[] args) {
        ParkingSlot s1 = new ParkingSlot("A1", 2);
        ParkingSlot s2 = new ParkingSlot("A2", 2);
        s1.allot("dummy"); // occupy one

        Employee e1 = new ManagerEmployee(101, "Divya", 70000, 8000);
        Employee e2 = new Employee(102, "Karan", 40000);
        Employee e3 = new InternEmployee(103, "Meera", 12000, 10000);

        CompanyEmployeeRecord r1 = new CompanyEmployeeRecord("Divya", "E101", e1, s1);
        CompanyEmployeeRecord r2 = new CompanyEmployeeRecord("Karan", "E102", e2, s2);
        CompanyEmployeeRecord r3 = new CompanyEmployeeRecord("Meera", "E103", e3, null); // no parking

        System.out.println(r1.fullProfile());
        System.out.println(r2.fullProfile());
        System.out.println(r3.fullProfile());
        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}