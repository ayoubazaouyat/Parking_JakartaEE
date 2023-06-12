package com.example.parhausprj;

public class Nachzahlen  extends State {

    @Override
    public State bezahle(Ticket t) {

        double dauer = t.austrittszeit.getTime() - t.bezahlzeit.getTime();
        if (dauer > 30.0) {
            t.setPrice(t.getTicketPrice() * dauer);
        }
        return new Nachzahlen() ;

    }

    @Override
    public State verliere(Ticket t) {
        t.setVerlustGeb(t.getVerlustGeb()+30.0);
        return new TicketVerloren();
    }

    @Override
    public State verlasse(Ticket t) {

        throw new IllegalStateException("You have to pay the extra fees first");
    }

}
