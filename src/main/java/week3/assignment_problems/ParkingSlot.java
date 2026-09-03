package week3.assignment_problems;

class ParkingSlot {
    String slotNo;
    int capacity;
    int occupiedCount;

    public ParkingSlot(String slotNo, int capacity) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = 0;
    }

    public boolean allot(String vehicleNo) {
        if (occupiedCount < capacity) {
            occupiedCount++;
            System.out.println(vehicleNo + " allotted to slot " + slotNo);
            return true;
        }
        return false;
    }

    public static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
        for (ParkingSlot s : slots) {
            if (s.occupiedCount < s.capacity) return s;
        }
        return null;
    }

    public static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
        ParkingSlot available = findAvailableSlot(slots);
        if (available == null) {
            System.out.println("No slots available for " + vehicleNo);
        } else {
            available.allot(vehicleNo);
        }
    }

    public static void main(String[] args) {
        ParkingSlot[] slots1 = { new ParkingSlot("A1", 4), new ParkingSlot("A2", 5) };
        // fill A2
        for (int i=0; i<5; i++) slots1[1].allot("dummy");
        // A1 has 0/4, so available
        safeAllot(slots1, "TN09AB1234");

        ParkingSlot[] slots2 = { new ParkingSlot("A1", 4), new ParkingSlot("A2", 5) };
        for (int i=0; i<4; i++) slots2[0].allot("dummy");
        for (int i=0; i<5; i++) slots2[1].allot("dummy");
        // now both full
        safeAllot(slots2, "TN09AB1234");
    }
}
/*
 * Passing the array does not copy the slots themselves because arrays are objects
 * and the reference is passed by value; the method operates on the same array
 * and the same slot objects in memory.
 */