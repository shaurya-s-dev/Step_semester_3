package week3.class_problems;

class SrmStudent {
    String name;
    String regNo;
    int attendance;

    public SrmStudent(String name, String regNo, int attendance) {
        this.name = name;
        this.regNo = regNo;
        this.attendance = attendance;
    }

    public void addAttendanceUpdate(int newAttendance) {
        this.attendance = newAttendance;
    }

    public boolean isEligible() {
        return attendance >= 75;
    }

    // Static because it operates on an array of students, not a single student's data.
    public static double classAverage(SrmStudent[] students) {
        int total = 0;
        for (SrmStudent s : students) total += s.attendance;
        return (double) total / students.length;
    }

    public static void main(String[] args) {
        SrmStudent[] students = {
            new SrmStudent("Ravi", "RA101", 82),
            new SrmStudent("Anitha", "RA102", 68),
            new SrmStudent("Karthik", "RA103", 91),
            new SrmStudent("Meera", "RA104", 74),
            new SrmStudent("Suresh", "RA105", 60)
        };

        for (SrmStudent s : students) {
            System.out.println(s.name + " - " + s.attendance + "% - " +
                               (s.isEligible() ? "Eligible" : "Detained"));
        }
        System.out.println("Class average: " + SrmStudent.classAverage(students) + "%");
    }
}
/*
 * classAverage is static because it belongs to the class and processes a collection.
 * isEligible is instance because it depends on a specific student's attendance.
 */