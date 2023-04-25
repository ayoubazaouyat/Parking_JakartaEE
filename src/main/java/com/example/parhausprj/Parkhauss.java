package com.example.parhausprj;

import com.example.parhausprj.ParkhausIF;

public class Parkhauss implements ParkhausIF {
    private String openingHours;

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }


    public String getOpeningHours() {
        return  this.openingHours ;
    }
}
