import com.example.parhausprj.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketVerlorenTest {

    private Ticket ticket;

    @BeforeEach
    void setUp() {
        ticket = new Ticket();
    }

    @Test
    @DisplayName("Test TicketVerloren state - bezahle()")
    void testTicketVerlorenBezahle() {
        TicketVerloren ticketVerloren = new TicketVerloren();

        ticket.setTicketPrice(10.0);
        double ticketValidierenResult = 1.5; // Replace with the expected result of ticketValidieren()
        ticket.setPrice(0.0);
        ticket.setVerlustGeb(20.0);

        State nextState = ticketVerloren.bezahle(ticket);

        Assertions.assertTrue(nextState instanceof TicketBezahlt);
        Assertions.assertEquals(35.0, ticket.getPrice()); // Replace with the expected price calculation based on ticketValidierenResult, ticket.getTicketPrice(), and ticket.getVerlustGeb()
    }

    @Test
    @DisplayName("Test TicketVerloren state - verliere()")
    void testTicketVerlorenVerliere() {
        TicketVerloren ticketVerloren = new TicketVerloren();

        State nextState = ticketVerloren.verliere(ticket);

        Assertions.assertTrue(nextState instanceof TicketVerloren);
    }

    @Test
    @DisplayName("Test TicketVerloren state - verlasse()")
    void testTicketVerlorenVerlasse() {
        TicketVerloren ticketVerloren = new TicketVerloren();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            ticketVerloren.verlasse(ticket);
        });
    }
}
