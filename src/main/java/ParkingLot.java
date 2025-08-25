import java.util.ArrayList;

public class ParkingLot {
    private int capacity;
    ArrayList<Car> parkingList;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingList = new ArrayList<>();
    }

    public Ticket park(Car car) {
        if (this.capacity > 0) {
            this.capacity -= 1;
            this.parkingList.add(car);
            return new Ticket(car.getId());
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
        if(!ticket.getTicketStatus()) {
            for(Car car :parkingList) {
                if(car.getId().equals(ticket.getId())) {
                    this.capacity += 1;
                    ticket.useTicket();
                    return car;
                }
            }
        }
        return null;
    }
}
