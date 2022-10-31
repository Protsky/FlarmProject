package com.hint.utils;

import com.hint.program.Competition;

public class searchGlider implements Runnable {

    //Ricevo N ID flarm dei partecipanti 
    Competition competition;
    Utils utils;

    String flarmId;
    public searchGlider(String id, Competition competition) {
        this.flarmId = id;
        this.competition = competition;
        utils =  new Utils(competition);
    }

    @Override
    public void run() {
        try {
            utils.searchGlider(flarmId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    public String getFlarmId() {
        return flarmId;
    }

    public void setFlarmId(String flarmId) {
        this.flarmId = flarmId;
    }

    
}
