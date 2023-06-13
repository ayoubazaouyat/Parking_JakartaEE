package com.example.parhausprj;

import org.junit.Assert;
import org.junit.Test;
import java.util.Date;

public class TicketBezahltTest {

    @Test(expected = IllegalStateException.class)
    public void testBezahle() {
        TicketBezahlt ticketBezahlt = new TicketBezahlt();
        Ticket ticket = new Ticket();
        ticketBezahlt.bezahle(ticket);
    }

    @Test
    public void testVerliere() {
        TicketBezahlt ticketBezahlt = new TicketBezahlt();
        Ticket ticket = new Ticket();
        double initialGeb = ticket.getVerlustGeb();
        State newState = ticketBezahlt.verliere(ticket);
        double newGeb = ticket.getVerlustGeb();
        Assert.assertTrue(newState instanceof TicketVerloren);
        Assert.assertEquals(initialGeb + 30.0, newGeb, 0.01);
    }

    @Test
    public void testVerlasseWithHalfHourDifference() {
        TicketBezahlt ticketBezahlt = new TicketBezahlt();
        Ticket ticket = new Ticket();
        ticket.setBezahlzeit(new Date(System.currentTimeMillis() - 30 * 60 * 1000)); // Set the payment time to half an hour ago
        State newState = ticketBezahlt.verlasse(ticket);
        Assert.assertTrue(newState instanceof Nachzahlen);
    }

    @Test
    public void testVerlasseWithinHalfHourDifference() {
        TicketBezahlt ticketBezahlt = new TicketBezahlt();
        Ticket ticket = new Ticket();
        ticket.setBezahlzeit(new Date()); // Set the payment time to the current time
        State newState = ticketBezahlt.verlasse(ticket);
        Assert.assertTrue(newState instanceof Ausgefahren);
        Assert.assertNotNull(ticket.getAustrittszeit());
        Assert.assertTrue(ticket.isOut());
    }
}
