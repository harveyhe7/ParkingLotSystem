import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {

    @Test
    public void test_smartParkingBoy_parking() {
        int capacity = 10;
        int fullCapacity = 0;
        String id = "12345";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, fullCapacity);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacity);
        List<ParkingLot> parkingLotArrayList = List.of(parkingLot1, parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy("John", parkingLotArrayList);
        Car car = new Car(id);
        //When
        Ticket ticket = smartParkingBoy.getParkingLot().park(car);
        //Then
        assertEquals("12345", ticket.getId());
        assertEquals(9, parkingLot2.getCapacity());
        assertTrue(parkingLot2.isCarExist(car.getId()));
    }

    @Test
    public void test_smartParkingBoy_full_parkingLot_parking() {
        int capacity = 0;
        String id = "12345";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, capacity);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacity);
        List<ParkingLot> parkingLotArrayList = List.of(parkingLot1, parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy("John", parkingLotArrayList);
        Car car = new Car(id);
        //When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> smartParkingBoy.getParkingLot().park(car));
        assertEquals("Not enough position", exception.getMessage());
    }

    @Test
    public void test_smartSmartParkingBoy_used_ticket_fetching() {
        int capacity = 10;
        String id = "12345";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, capacity);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacity);
        List<ParkingLot> parkingLotArrayList = List.of(parkingLot1, parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy("John", parkingLotArrayList);
        Car car = new Car(id);
        Ticket ticket = parkingLot2.park(car);
        parkingLot2.fetch(ticket);
        //When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> smartParkingBoy.getParkingLot(ticket).fetch(ticket));
        assertEquals("Unrecognized ticket", exception.getMessage());
    }


    @Test
    public void test_smartSmartParkingBoy_ticket_fetching_car_in_parkingLot2() {
        int capacity = 10;
        String id = "12345";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, capacity);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacity);
        List<ParkingLot> parkingLotArrayList = List.of(parkingLot1, parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy("John", parkingLotArrayList);
        Car car = new Car(id);
        Ticket ticket = parkingLot2.park(car);

        //When
        Car fetchedCar = smartParkingBoy.getParkingLot(ticket).fetch(ticket);

        //Then
        assertEquals(car, fetchedCar);
    }

    @Test
    public void test_smartParkingBoy_normal_parking() {
        int capacityMax = 10;
        int capacityMin = 8;
        String id = "12345";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, capacityMin);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacityMax);
        List<ParkingLot> parkingLotArrayList = List.of(parkingLot1, parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy("John", parkingLotArrayList);
        Car car = new Car(id);
        //When
        Ticket ticket = smartParkingBoy.getParkingLot().park(car);
        //Then
        assertEquals("12345", ticket.getId());
        assertEquals(9, parkingLot2.getCapacity());
        assertTrue(parkingLot2.isCarExist(car.getId()));
    }
}
