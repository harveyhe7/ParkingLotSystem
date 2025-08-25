import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingTest {
    @Test
    public void test_normal_parking() {
        int capacity = 10;
        String id = "12345";
        //given
        ParkingLot parkingLot = new ParkingLot(capacity);
        Car car = new Car(id);
        //When
        Ticket ticket = parkingLot.park(car);
        //Then
        assertEquals("12345", ticket.getId());
        assertEquals(9, parkingLot.getCapacity());
        assertTrue(parkingLot.isCarExist(car.getId()));
    }

    @Test
    public void test_normal_fetching() {
        //Given
        int capacity = 10;
        String id = "12345";
        ParkingLot parkingLot = new ParkingLot(capacity);
        Car car = new Car(id);
        Ticket ticket = parkingLot.park(car);

        // When
        Car fetchedCar = parkingLot.fetch(ticket);

        assertEquals(car.getId(), ticket.getId());
        assertEquals(10, parkingLot.getCapacity());
        assertTrue(ticket.getTicketStatus());


    }
}
