import java.util.List;

public class ParkingBoy {
    private String name;
    protected List<ParkingLot> parkingLotArrayList;
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
        return parkingLotArrayList.get(0);
    }

    public ParkingLot getParkingLot(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLotArrayList) {
            if (ticket.getParkingLotId().equals(parkingLot.getParkingLotId())) {
                return parkingLot;
            }
        }
        return parkingLotArrayList.get(0);
    }
}
