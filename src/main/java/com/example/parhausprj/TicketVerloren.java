package com.example.parhausprj;

public class TicketVerloren extends State {
    @Override
    public State bezahle(Ticket t) {
        if (t.getPrice() == 0.0) {
            double dauer = t.ticketValidieren();
            t.setPrice(rounded((t.getTicketPrice()*dauer)+t.getVerlustGeb()));
        } else {
            t.setPrice(t.getPrice()+t.getVerlustGeb());
        }

        return new TicketBezahlt();
    }

    @Override
    public State verliere(Ticket t) {
        return new TicketVerloren();
    }

    @Override
    public State verlasse(Ticket t) {
        throw new IllegalStateException("pay for your lost Ticket");
    }
}
