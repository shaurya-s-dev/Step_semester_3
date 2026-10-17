package linked_list.class_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 3: Student Marks Grid
 *
 * TASK:
 * Implement a system to manage student marks. You will be given student names and their marks
 * for various subjects. Some students might not have marks for all subjects. Represent this
 * data efficiently, possibly using a 2D array or similar structure.
 * The system should be able to calculate and report the total marks for each student.
 * Additionally, it should identify and report the topper (student with the highest mark) for
 * each subject, along with their score.
 */
public class StudentMarksGrid {

    private String[] subjects;
    private List<String> studentNames;
    private List<Integer[]> marksGrid; // Each row represents a student's marks per subject; null if missing

    public StudentMarksGrid(String... subjects) {
        this.subjects = subjects;
        this.studentNames = new ArrayList<>();
        this.marksGrid = new ArrayList<>();
    }

    /**
     * Adds a student and their marks corresponding to subjects.
     * Missing marks can be omitted or passed as null.
     */
    public void addStudent(String name, Integer... marks) {
        studentNames.add(name);
        Integer[] row = new Integer[subjects.length];
        for (int i = 0; i < subjects.length; i++) {
            if (i < marks.length) {
                row[i] = marks[i];
            } else {
                row[i] = null;
            }
        }
        marksGrid.add(row);
    }

    /**
     * Computes the total marks for each student.
     * Format: Totals Anu 240, Ravi 145, Meena 258
     */
    public String getTotals() {
        StringBuilder sb = new StringBuilder("Totals ");
        for (int i = 0; i < studentNames.size(); i++) {
            String name = studentNames.get(i);
            Integer[] row = marksGrid.get(i);
            int total = 0;
            for (Integer mark : row) {
                if (mark != null) {
                    total += mark;
                }
            }
            sb.append(name).append(" ").append(total);
            if (i < studentNames.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /**
     * Finds the topper for each subject.
     * Format: toppers Math Meena 95, Sci Anu 90, Eng Meena 88
     */
    public String getToppers() {
        StringBuilder sb = new StringBuilder("toppers ");
        for (int s = 0; s < subjects.length; s++) {
            String subject = subjects[s];
            int maxMark = -1;
            String topper = "";

            for (int i = 0; i < studentNames.size(); i++) {
                Integer mark = marksGrid.get(i)[s];
                if (mark != null && mark > maxMark) {
                    maxMark = mark;
                    topper = studentNames.get(i);
                }
            }

            sb.append(subject).append(" ").append(topper).append(" ").append(maxMark);
            if (s < subjects.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
