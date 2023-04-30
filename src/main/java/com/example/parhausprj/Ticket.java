package com.example.parhausprj;

import java.util.Date;

public class Ticket {
    int ticketNummer ;

    public String getAutoNummer() {
        return autoNummer;
    }

    String autoNummer;
    public double ticketPrice;
    public Date eintrittszeit;
    public Date austrittszeit;
    boolean verloren;
    double verlustGeb= 50.0;
    boolean bezahlt = false ;


    public int getTicketNummer() {
        return ticketNummer;
    }

    public Ticket(int ticketNummer, String autoNummer, double ticketPrice) {
        this.verloren = false;
        this.ticketPrice = ticketPrice;
        this.ticketNummer = ticketNummer;
        this.autoNummer = autoNummer;
    }

    public void setTicketPrice(double ticketPrice) {
        if (ticketPrice < 0) {
            throw new IllegalArgumentException("Ticketpreis darf nicht negativ sein!");
        }
        this.ticketPrice = ticketPrice;
    }



    public double bezahlen() {
        double dauer = this.ticketValidieren();
        if (bezahlt) {
            throw new IllegalStateException("You already paid your ticket!");
        }
        if(verloren) {
            bezahlt = true;
            return (this.ticketPrice*dauer)+ verlustGeb;
        } else {
            bezahlt = true;
            return this.ticketPrice*dauer;
        }
    }


    public Date ticketZiehen() {
        eintrittszeit = new Date();
        return eintrittszeit;
    }

    public double ticketValidieren() {
        if (eintrittszeit == null) {
            throw new IllegalStateException("Eintrittszeit wurde nicht gesetzt.");
        }
        austrittszeit = new Date();
        long parkdauerInMillisekunden = austrittszeit.getTime() - eintrittszeit.getTime();
        double parkdauerInStunden = (parkdauerInMillisekunden / (60.0 * 60.0 * 1000.0)); // Umrechnung von Millisekunden in Stunden
        // weitere Schritte, um das Ticket zu validieren und den Preis zu berechnen
        return parkdauerInStunden;
    }



    public void verloren() {
        this.verloren = true;
    }
    public double getTicketPrice() {
        return this.ticketPrice;
    }

    public double getVerlustGeb() {
        return verlustGeb;
    }

    public Date getEintrittszeit() {
        return eintrittszeit;
    }

    public boolean isVerloren() {
        return verloren;
    }


}
