import com.example.parhausprj.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestParkplatz {

    private Parkplatz parkplatz;

    @BeforeEach
    public void setUp() {
        parkplatz = new Parkplatz(10);
    }

    @Test
    public void testReserveParkingSpace_WhenSpaceAvailable() {
        String autonummer = "AA-AA-0000";
        int spaceNumber = 1;

        Parkplatz.ParkingSpace reservedSpace = parkplatz.reserveParkingSpace(spaceNumber, autonummer);

        Assertions.assertNotNull(reservedSpace);
        Assertions.assertEquals(spaceNumber, reservedSpace.getNumber());
        Assertions.assertFalse(reservedSpace.isAvailable());
        Assertions.assertEquals(autonummer, reservedSpace.getAutonummer());
    }

    @Test
    public void testReserveParkingSpace_WhenSpaceUnavailable() {
        String autonummer1 = "AA-AA-0000";
        String autonummer2 = "AA-AA-0001";
        int spaceNumber = 1;

        parkplatz.reserveParkingSpace(spaceNumber, autonummer1);

        Parkplatz.ParkingSpace reservedSpace = parkplatz.reserveParkingSpace(spaceNumber, autonummer2);

        Assertions.assertNull(reservedSpace);
    }

    @Test
    public void testReleaseParkingSpace() {
        String autonummer = "AA-AA-0000";
        int spaceNumber = 1;

        Parkplatz.ParkingSpace reservedSpace = parkplatz.reserveParkingSpace(spaceNumber, autonummer);
        parkplatz.releaseParkingSpace(reservedSpace);

        Assertions.assertTrue(reservedSpace.isAvailable());
        Assertions.assertNull(reservedSpace.getAutonummer());
    }

    @Test
    public void testGetSpace() {
        int spaceNumber = 1;

        Parkplatz.ParkingSpace space = parkplatz.getSpace(spaceNumber - 1);

        Assertions.assertNotNull(space);
        Assertions.assertEquals(spaceNumber, space.getNumber());
    }

}
