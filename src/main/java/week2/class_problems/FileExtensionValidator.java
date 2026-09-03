package week2.class_problems;

public class FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot == -1) return "Rejected — invalid file type";
        String ext = filename.substring(dot + 1);
        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip"))
            return "Accepted";
        else
            return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}