package com.example.parhausprj;

public class Ausgefahren  extends State {

    @Override
    public State bezahle(Ticket t) {
        throw new IllegalStateException("You are already out");
    }

    @Override
    public State verliere(Ticket t) {
        throw new IllegalStateException("You are already out");
    }

    @Override
    public State verlasse(Ticket t) {
        throw new IllegalStateException("You are already out");
    }
}
