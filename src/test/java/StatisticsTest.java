import com.example.parhausprj.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticsTest {

    @Test
    public void testTicketStatistics() {
        // Create a list of Ticket objects
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket1 = new Ticket(1,"AA-AA-0000",10);
        ticket1.setVerlustGeb(5.0);
        myLocalDate.timewarp(60);
        ticket1.bezahlen();
        ticket1.verlasse();
        tickets.add(ticket1);

        Ticket ticket2 = new Ticket(2,"AA-AA-0000",15);
        ticket2.setVerlustGeb(8.0);
        myLocalDate.timewarp(60);
        ticket2.bezahlen();
        ticket2.verlasse();
        tickets.add(ticket2);

        // Create a Ticket instance and set the list of tickets
        Ticket ticket = new Ticket(3,"AA-AA-0000",15);
        //ticket.setOutTickets(tickets);
        //ticket.setOutTicketsSize(tickets.size());

        // Calculate the expected values manually
        double expectedPaidAvg = (10. +15.) / 2.0;
        double expectedPaidPercentage = (2.0 / 2.0) * 100.0;
        double expectedVerlustGAvg = (5.0 + 8.0) / 2.0;
        double expectedTimeAvg = (2.0) / 2.0;

        // Call the code under test
        double paidAvg = tickets.stream()
                .filter(x -> x.austrittszeit != null).mapToDouble(Ticket::getPrice).average().orElse(0.0);
        double paidPercentage = (double) tickets.stream()
                .filter(x -> x.austrittszeit != null)
                .collect(Collectors.toList()).size() / tickets.size() * 100.0;
        double verlustGAvg = tickets.stream()
                .filter(x -> x.austrittszeit != null)
                .collect(Collectors.toList()).stream().mapToDouble(Ticket::getVerlustGeb).average().orElse(0.0);
        double timeAvg = ticket.getOutTickets().stream().mapToDouble(x ->
                Duration.between(x.getEintrittszeit(), x.getBezahlzeit()).toHours() +
                        (double)(Duration.between(x.getEintrittszeit(), x.getBezahlzeit()).toMinutes() % 60) / 60.0
        ).average().orElse(0.0);

        // Compare the expected values with the actual values
        assertEquals(expectedPaidAvg, paidAvg, 0.0001);
        assertEquals(expectedPaidPercentage, paidPercentage, 0.0001);
        assertEquals(expectedVerlustGAvg, verlustGAvg, 0.0001);
        assertEquals(expectedTimeAvg, timeAvg, 0.0001);
    }
}
