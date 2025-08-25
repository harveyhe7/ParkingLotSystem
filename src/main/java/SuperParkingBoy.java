import java.util.List;

public class SuperParkingBoy extends ParkingBoy{
    public SuperParkingBoy(String name, List<ParkingLot> parkingLotArrayList) {
        super(name, parkingLotArrayList);
    }
    public ParkingLot getParkingLot() {
        ParkingLot optimumParkingLot = parkingLotArrayList.get(0);
        for (ParkingLot parkingLot : parkingLotArrayList) {
            if (parkingLot.getCapacity() != 0) {
                if (parkingLot.getCapacity() / parkingLot.getInitialCapacity()  > optimumParkingLot.getCapacity() / optimumParkingLot.getInitialCapacity()) {
                    optimumParkingLot = parkingLot;
                }
            }
        }
        return optimumParkingLot;
    }

}
