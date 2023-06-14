import com.example.parhausprj.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketGezogenTest  {

    private Ticket ticket;

    @BeforeEach
    void setUp() {
        ticket = new Ticket();
    }

    @Test
    @DisplayName("Test TicketGezogen state - bezahle()")
    void testTicketGezogenBezahle() {
        TicketGezogen ticketGezogen = new TicketGezogen();

        ticket.setTicketPrice(10.0);
        double ticketValidierenResult = 1.5; // Replace with the expected result of ticketValidieren()
        ticket.setPrice(0.0);

        State nextState = ticketGezogen.bezahle(ticket);

        Assertions.assertTrue(nextState instanceof TicketBezahlt);
        Assertions.assertEquals(15.0, ticket.getPrice()); // Replace with the expected price calculation based on ticketValidierenResult and ticket.getTicketPrice()
    }

    @Test
    @DisplayName("Test TicketGezogen state - verliere()")
    void testTicketGezogenVerliere() {
        TicketGezogen ticketGezogen = new TicketGezogen();

        ticket.setVerlustGeb(0.0);
        State nextState = ticketGezogen.verliere(ticket);

        Assertions.assertTrue(nextState instanceof TicketVerloren);
        Assertions.assertEquals(30.0, ticket.getVerlustGeb());
    }

    @Test
    @DisplayName("Test TicketGezogen state - verlasse()")
    void testTicketGezogenVerlasse() {
        TicketGezogen ticketGezogen = new TicketGezogen();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            ticketGezogen.verlasse(ticket);
        });
    }
}
