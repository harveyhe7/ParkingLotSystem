import java.util.ArrayList;

public class ParkingLot {
    private String parkingLotId;
    private int capacity;
    ArrayList<Car> parkingList;

    public ParkingLot(String parkingLotId, int capacity) {
        this.parkingLotId = parkingLotId;
        this.capacity = capacity;
        this.parkingList = new ArrayList<>();
    }

    public Ticket park(Car car) {
        if (this.capacity > 0) {
            this.capacity -= 1;
            this.parkingList.add(car);
            return new Ticket(car.getId(), this.parkingLotId);
        }
        return null;
    }

    public boolean isCarExist(String id) {
        for (Car car : parkingList) {
            if (id.equals(car.getId())) {
                return true;
            }
        }
        return false;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Car fetch(Ticket ticket) {
        if (!ticket.getParkingLotId().equals(this.parkingLotId)) {
            return null;

        }
        if(!ticket.getTicketStatus()) {
            for(Car car :parkingList) {
                if(car.getId().equals(ticket.getId())) {
                    this.capacity += 1;
                    this.parkingList.remove(car);
                    ticket.useTicket();
                    return car;
                }
            }
        }
        return null;
    }
}
