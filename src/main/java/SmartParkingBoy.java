import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    //继承ParkingBoy

    public SmartParkingBoy(String name, List<ParkingLot> parkingLotArrayList) {
        super(name, parkingLotArrayList);
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

}
