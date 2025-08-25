import java.util.List;

public class SmartParkingBoy {
    private String name;
    private List<ParkingLot> parkingLotArrayList;
    public SmartParkingBoy(String name, List<ParkingLot> parkingLotArrayList) {
        this.name = name;
        this.parkingLotArrayList = parkingLotArrayList;
    }
    public ParkingLot getParkingLot() {
        ParkingLot optimumParkingLot = parkingLotArrayList.get(0);
        for (ParkingLot parkingLot : parkingLotArrayList) {
            if (parkingLot.getCapacity() != 0) {
                if (parkingLot.getCapacity() > optimumParkingLot.getCapacity()) {
                    optimumParkingLot = parkingLot;
                }
            }
        }
        return optimumParkingLot;
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
