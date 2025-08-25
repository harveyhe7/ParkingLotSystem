import java.util.List;

public class ParkingBoy {
    private String name;
    private List<ParkingLot> parkingLotArrayList;
    public ParkingBoy(String name, List<ParkingLot> parkingLotArrayList) {
        this.name = name;
        this.parkingLotArrayList = parkingLotArrayList;
    }
    public ParkingLot getParkingLot() {
        for (ParkingLot parkingLot : parkingLotArrayList) {
            if (parkingLot.getCapacity() != 0) {
                return parkingLot;
            }
        }
        return parkingLotArrayList.getFirst();
    }
}
