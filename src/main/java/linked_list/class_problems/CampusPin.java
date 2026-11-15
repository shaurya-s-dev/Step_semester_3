package linked_list.class_problems;

/**
 * Problem 4: Campus Map Pins
 *
 * TASK:
 * CampusPin declares public static String banner = "Campus", public String name = "General Pin"
 * and public String getDetails() returning "Details: " + name.
 * HostelPin extends CampusPin and declares its own banner = "Hostel", name = "Hostel Pin"
 * and an overriding getDetails() with the same body.
 *
 * In main, write CampusPin p = new HostelPin(); and print p.banner, p.name and p.getDetails().
 * For each line, state whether the reference type or the object type decided the value, and explain why.
 */
public class CampusPin {
    public static String banner = "Campus";
    public String name = "General Pin";

    public String getDetails() {
        return "Details: " + name;
    }

    public static class HostelPin extends CampusPin {
        public static String banner = "Hostel";
        public String name = "Hostel Pin";

        @Override
        public String getDetails() {
            return "Details: " + name;
        }
    }

    public static void main(String[] args) {
        CampusPin p = new HostelPin();

        System.out.println("banner: " + p.banner + " (decided by reference type)");
        System.out.println("name: " + p.name + " (decided by reference type)");
        System.out.println(p.getDetails() + " (decided by object type)");
    }
}
