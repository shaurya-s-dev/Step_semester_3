package week3.class_problems;

class HostelRoom {
    String roomNo;
    int beds;
    int occupied;

    public HostelRoom(String roomNo, int beds) {
        this.roomNo = roomNo;
        this.beds = beds;
        this.occupied = 0;
    }

    public boolean allot(String name) {
        if (occupied < beds) {
            occupied++;
            System.out.println(name + " allotted to room " + roomNo);
            return true;
        }
        return false;
    }

    public static HostelRoom findAvailableRoom(HostelRoom[] rooms) {
        for (HostelRoom r : rooms) {
            if (r.occupied < r.beds) return r;
        }
        return null;
    }

    public static void safeAllot(HostelRoom[] rooms, String studentName) {
        HostelRoom available = findAvailableRoom(rooms);
        if (available == null) {
            System.out.println("No rooms available for " + studentName);
        } else {
            available.allot(studentName);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Available room
        HostelRoom[] rooms1 = { new HostelRoom("C-214", 3), new HostelRoom("C-507", 2) };
        // C-507 is full (2/2)
        rooms1[1].occupied = 2;
        safeAllot(rooms1, "Divya");

        // Test Case 2: All full
        HostelRoom[] rooms2 = { new HostelRoom("C-214", 3), new HostelRoom("C-507", 2) };
        rooms2[0].occupied = 3;
        rooms2[1].occupied = 2;
        safeAllot(rooms2, "Divya");
    }
}
/*
 * Passing the array does not copy the rooms because arrays are objects.
 * The method receives a reference to the same array in memory.
 */