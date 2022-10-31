package com.hint.objects;

import java.util.ArrayList;

public class Flight {
    private Airplane airplane;
    private ArrayList<InstancePosition> positions = new ArrayList<>();

    public Flight(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public ArrayList<InstancePosition> getPositions() {
        return positions;
    }
    

    public void setPositions(ArrayList<InstancePosition> positions) {
        this.positions = positions;
    }

    public void addInstance(Float altitude, Double longitude, Double latitude, Float verticalSpeed, int track, double time){
        positions.add(new InstancePosition(altitude,longitude,latitude,verticalSpeed,track,time));
    }

}
