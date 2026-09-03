package week2.class_problems;

public class MaskedPhoneNumber {
    public static String maskPhoneNumber(String phone) {
        if (phone.length() != 10 || !phone.matches("\\d+")) {
            return "Invalid phone number";
        }
        String last4 = phone.substring(6);
        return "XXXXXX-" + last4;
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}