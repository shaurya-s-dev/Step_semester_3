package week2.class_problems;

public class StudentRecordParser {
    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.printf("Name: %s | Roll No: %s | Dept: %s%n", fields[0], fields[1], fields[2]);
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
    }
}