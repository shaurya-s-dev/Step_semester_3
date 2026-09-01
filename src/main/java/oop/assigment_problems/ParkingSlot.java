package oop.assigment_problems;

public class ParkingSlot {
    private String slotNo;
    private int capacity;
    private int occupiedCount;

    public ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public void allot(String vehicleNo) {
        occupiedCount++;
        System.out.println(vehicleNo + " allotted to slot " + slotNo);
    }

    public static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
        for (ParkingSlot slot : slots) {
            if (slot.occupiedCount < slot.capacity) {
                return slot;
            }
        }
        return null;
    }

    public static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
        ParkingSlot slot = findAvailableSlot(slots);
        if (slot != null) {
            slot.allot(vehicleNo);
        } else {
            System.out.println("No slots available for " + vehicleNo);
        }
    }

    // Arrays hold references to the same ParkingSlot objects in memory,
    // so passing the array only copies the reference list, not the objects —
    // changes made inside these methods affect the original slots.
    public static void main(String[] args) {
        ParkingSlot[] slots1 = { new ParkingSlot("A1", 4, 3), new ParkingSlot("A2", 5, 5) };
        safeAllot(slots1, "TN09AB1234");

        ParkingSlot[] slots2 = { new ParkingSlot("A1", 4, 4), new ParkingSlot("A2", 5, 5) };
        safeAllot(slots2, "TN09AB1234");
    }
}