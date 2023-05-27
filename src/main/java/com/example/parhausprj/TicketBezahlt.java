package com.example.parhausprj;

import java.util.Date;

public class TicketBezahlt extends State {
    @Override
    public State bezahle(Ticket t) {
        throw new IllegalStateException("You already Paid!");
    }

    @Override
    public State verliere(Ticket t) {
        t.setVerlustGeb(t.getVerlustGeb()+30.0);
        return new TicketVerloren();
    }

    @Override
    public State verlasse(Ticket t) {
        Date date = new Date();
        double zwiscehnzeit = (date.getTime() - t.getBezahlzeit().getTime())/ (60.0 * 60.0 * 1000.0);
        System.out.println(t.getBezahlzeit().getTime());
        System.out.println(date.getTime());
        System.out.println(zwiscehnzeit);
        if (zwiscehnzeit > 0.5) {
            return new Nachzahlen();
        }else {
            t.setAustrittszeit(new Date());
            Offnungzeitenservlet.Freeplaces++;
            Parkhauss.lots[t.place] = null ; // empty parking place
            return new Ausgefahren();
        }
    }
}
