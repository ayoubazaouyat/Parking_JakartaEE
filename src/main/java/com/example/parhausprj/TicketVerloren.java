package com.example.parhausprj;

public class TicketVerloren extends State implements StatesInt{
    @Override
    public State bezahle(Ticket t) {
        t.setPrice(t.getPrice()+t.getVerlustGeb());
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
