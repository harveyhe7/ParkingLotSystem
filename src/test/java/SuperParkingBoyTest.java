import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperParkingBoyTest {

    @Test
    public void test_superParkingBoy_parking() {
        int capacity = 10;
        int fullCapacity = 1;
        String id1 = "12345";
        String id2 = "01234";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, fullCapacity);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacity);
        List<ParkingLot> parkingLotArrayList = List.of(parkingLot1, parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy("John", parkingLotArrayList);
        Car car1 = new Car(id1);
        parkingLot1.park(car1);

        Car car2 = new Car(id2);
        //When
        Ticket ticket = superParkingBoy.getParkingLot().park(car2);
        //Then
        assertEquals(id2, ticket.getId());
        assertEquals(9, parkingLot2.getCapacity());
        assertTrue(parkingLot2.isCarExist(car2.getId()));
    }

    @Test
    public void test_superParkingBoy_full_parkingLot_parking() {
        int capacity = 0;
        String id = "12345";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, capacity);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacity);
        List<ParkingLot> parkingLotArrayList = List.of(parkingLot1, parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy("John", parkingLotArrayList);
        Car car = new Car(id);
        //When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> superParkingBoy.getParkingLot().park(car));
        assertEquals("Not enough position", exception.getMessage());
    }

    @Test
    public void test_superParkingBoy_used_ticket_fetching() {
        int capacity = 10;
        String id = "12345";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, capacity);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacity);
        List<ParkingLot> parkingLotArrayList = List.of(parkingLot1, parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy("John", parkingLotArrayList);
        Car car = new Car(id);
        Ticket ticket = parkingLot2.park(car);
        parkingLot2.fetch(ticket);
        //When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> superParkingBoy.getParkingLot(ticket).fetch(ticket));
        assertEquals("Unrecognized ticket", exception.getMessage());
    }


    @Test
    public void test_superParkingBoy_ticket_fetching_car_in_parkingLot2() {
        int capacity = 10;
        String id = "12345";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, capacity);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacity);
        List<ParkingLot> parkingLotArrayList = List.of(parkingLot1, parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy("John", parkingLotArrayList);
        Car car = new Car(id);
        Ticket ticket = parkingLot2.park(car);

        //When
        Car fetchedCar = superParkingBoy.getParkingLot(ticket).fetch(ticket);

        //Then
        assertEquals(car, fetchedCar);
    }

    @Test
    public void test_superParkingBoy_normal_parking() {
        int capacity1 = 2;

        int capacity2 = 5;

        String id1 = "12345";
        String id2 = "67890";
        String id3 = "54321";
        String id4 = "09876";
        String id5 = "02332";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, capacity1);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacity2);
        List<ParkingLot> parkingLotArrayList = List.of(parkingLot1, parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy("John", parkingLotArrayList);
        Car car1 = new Car(id1);
        Car car2 = new Car(id2);
        Car car3 = new Car(id3);
        Car car4 = new Car(id4);
        Car car5 = new Car(id5);

        parkingLot1.park(car1);
        parkingLot2.park(car2);
        parkingLot2.park(car3);
        parkingLot2.park(car4);
        //When
        Ticket ticket = superParkingBoy.getParkingLot().park(car5);
        //Then
        assertEquals(id5, ticket.getId());
        assertEquals(0, parkingLot1.getCapacity());
        assertTrue(parkingLot1.isCarExist(car5.getId()));
    }
}
