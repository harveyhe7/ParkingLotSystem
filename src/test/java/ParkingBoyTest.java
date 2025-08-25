import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingBoyTest {

    @Test
    public void test_parkingBoy_parking() {
        int capacity = 10;
        int fullCapacity = 0;
        String id = "12345";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, fullCapacity);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacity);
        List<ParkingLot> parkingLotArrayList = List.of(parkingLot1, parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy("John", parkingLotArrayList);
        Car car = new Car(id);
        //When
        Ticket ticket = parkingBoy.getParkingLot().park(car);
        //Then
        assertEquals("12345", ticket.getId());
        assertEquals(9, parkingLot2.getCapacity());
        assertTrue(parkingLot2.isCarExist(car.getId()));
    }

    @Test
    public void test_parkingBoy_full_parkingLot_parking() {
        int capacity = 0;
        String id = "12345";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, capacity);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacity);
        List<ParkingLot> parkingLotArrayList = List.of(parkingLot1, parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy("John", parkingLotArrayList);
        Car car = new Car(id);
        //When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> parkingBoy.getParkingLot().park(car));
        assertEquals("Not enough position", exception.getMessage());
    }

    @Test
    public void test_parkinBoy_used_ticket_fetching() {
        int capacity = 10;
        String id = "12345";
        String parkingLotId1 = "1";
        String parkingLotId2 = "2";
        ParkingLot parkingLot1 = new ParkingLot(parkingLotId1, capacity);
        ParkingLot parkingLot2 = new ParkingLot(parkingLotId2, capacity);
        List<ParkingLot> parkingLotArrayList = List.of(parkingLot1, parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy("John", parkingLotArrayList);
        Car car = new Car(id);
        Ticket ticket = parkingLot2.park(car);
        parkingLot2.fetch(ticket);
        //When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> parkingBoy.getParkingLot().fetch(ticket));
        assertEquals("Unrecognized ticket", exception.getMessage());
    }
}
