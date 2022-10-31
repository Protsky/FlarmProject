package com.hint.objects;

public class Airplane {
    private String flarmId;
    private Pilot pilot;

    public Airplane(String flarmId, Pilot pilot) {
        this.flarmId = flarmId;
        this.pilot = pilot;
    }

    public String getflarmId() {
        return flarmId;
    }

    public void setflarmId(String flarmId) {
        this.flarmId = flarmId;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    @Override
    public String toString() {
        return "{" +
            " flarmId='" + getflarmId() + "'" +
            ", pilot='" + getPilot() + "'" +
            "}";
    }


}
