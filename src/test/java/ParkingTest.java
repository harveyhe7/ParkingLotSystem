import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingTest {
    @Test
    public void test_normal_parking() {
        int capacity = 10;
        String id = "12345";
        String parkingLotId1 = "1";
        //given
        ParkingLot parkingLot = new ParkingLot(parkingLotId1, capacity);
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
        String parkingLotId1 = "1";
        ParkingLot parkingLot = new ParkingLot(parkingLotId1, capacity);
        Car car = new Car(id);
        Ticket ticket = parkingLot.park(car);

        // When
        Car fetchedCar = parkingLot.fetch(ticket);

        assertEquals(car.getId(), ticket.getId());
        assertEquals(10, parkingLot.getCapacity());
        assertTrue(ticket.getTicketStatus());
        assertFalse(parkingLot.isCarExist(fetchedCar.getId()));

    }

    @Test
    public void test_not_corresponding_ticket_fetching() {
        //Given
        int capacity = 10;
        String carId = "12345";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, capacity);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacity);
        Car car = new Car(carId);
        Ticket ticket = parkingLot1.park(car);
        //When
        Car fetchedCar = parkingLot2.fetch(ticket);
        //Then
        assertNull(fetchedCar);
    }

    @Test
    public void test_used_ticket_fetching() {
        int capacity = 10;
        String id = "12345";
        String parkingLotId1 = "1";
        //given
        ParkingLot parkingLot = new ParkingLot(parkingLotId1, capacity);
        Car car = new Car(id);
        Ticket ticket = parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(ticket);
        //When
        Car fechedDuplicateCar = parkingLot.fetch(ticket);
        //Then

        assertNull(fechedDuplicateCar);
    }

    @Test
    public void test_full_parkingLot_parking() {
        int capacity = 0;
        String id = "12345";
        String parkingLotId1 = "1";
        //given
        ParkingLot parkingLot = new ParkingLot(parkingLotId1, capacity);
        Car car = new Car(id);
        //When
        Ticket ticket = parkingLot.park(car);
        //Then
        assertNull(ticket);
    }


}
