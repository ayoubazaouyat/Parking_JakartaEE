import com.example.parhausprj.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class TicketBezahltTest {

    @BeforeEach
    public void setUp() {
        // Set up any necessary test data or configurations
    }

    @Test
    @DisplayName("Test bezahle method")
    public void testBezahle() {
        TicketBezahlt ticketBezahlt = new TicketBezahlt();
        Ticket ticket = new Ticket();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            ticketBezahlt.bezahle(ticket);
        });
    }

    @Test
    @DisplayName("Test verliere method")
    public void testVerliere() {
        TicketBezahlt ticketBezahlt = new TicketBezahlt();
        Ticket ticket = new Ticket();
        State nextState = ticketBezahlt.verliere(ticket);
        Assertions.assertTrue(nextState instanceof TicketVerloren);
        Assertions.assertEquals(30.0, ticket.getVerlustGeb(), 0.0);
    }

    @Test
    @DisplayName("Test verlasse method")
    public void testVerlasse() {
        TicketBezahlt ticketBezahlt = new TicketBezahlt();
        Ticket ticket = new Ticket();
        ticket.setBezahlzeit(new Date(System.currentTimeMillis() - 1000)); // Set payment time 1 second ago
        State nextState = ticketBezahlt.verlasse(ticket);
        Assertions.assertTrue(nextState instanceof Nachzahlen);
    }
}
