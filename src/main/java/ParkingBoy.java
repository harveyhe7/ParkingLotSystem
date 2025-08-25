public class ParkingBoy {
    private String name;
    private ParkingLot parkingLot;
    public ParkingBoy(String name, ParkingLot parkingLot) {
        this.name = name;
        this.parkingLot = parkingLot;
    }
    public ParkingLot getParkingLot() {
        return this.parkingLot;
    }
}
