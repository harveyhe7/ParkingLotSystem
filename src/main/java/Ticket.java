public class Ticket {
    private String id;
    private boolean isUsed;
    public Ticket(String id) {
        this.id = id;
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


}
