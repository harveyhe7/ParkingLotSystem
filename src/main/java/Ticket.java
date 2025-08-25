public class Ticket {
    private String id;
    private boolean isUsed;
    private String parkingLotId;
    public Ticket(String id, String parkingLotId) {
        this.id = id;
        this.parkingLotId = parkingLotId;
        this.isUsed = false;
    }
    public String getId() {
        return this.id;
    }

    public boolean getIsUsed() {
        return this.isUsed;
    }

    public void useTicket() {
        this.isUsed = true;
    }

    public boolean getTicketStatus() {
        return this.isUsed;
    }


    public Object getParkingLotId() {
        return this.parkingLotId;
    }
}
