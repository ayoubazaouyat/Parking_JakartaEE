package com.example.parhausprj;

import java.util.ArrayList;
import java.util.List;

public class Parkplatz {

    public static List<ParkingSpace> parkingSpaces;

    public Parkplatz(int numSpaces) {
        parkingSpaces = new ArrayList<>(numSpaces);
        for (int i = 1; i <= numSpaces; i++) {
            parkingSpaces.add(new ParkingSpace(i));
        }
    }
    public static ParkingSpace reserveParkingSpace(int spaceNumber) {
        for (ParkingSpace parkingSpace : parkingSpaces) {
            if (parkingSpace.getNumber() == spaceNumber && parkingSpace.isAvailable()) {
                parkingSpace.setAvailable(false);
                Offnungzeitenservlet.Freeplaces--;
                return parkingSpace;
            }
        }
        return null;
    }
    public  ParkingSpace getSpace(int i) {
        return parkingSpaces.get(i);
    }


    public void releaseParkingSpace(ParkingSpace parkingSpace) {
        parkingSpace.setAvailable(true);
    }

    class ParkingSpace {
        private int number;
        private boolean available;

        public ParkingSpace(int number) {
            this.number = number;
            available = true;
        }

        public int getNumber() {
            return number;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }


    }

}
