package com.hint.objects;

public class InstancePosition {
    private float altitude;
    private double longitude;
    private double latitude;
    private float verticalSpeed;
    private double bearing;
    private double time;

    public InstancePosition(float altitude, double longitude, double latitude, float verticalSpeed, double bearing, double time) {
        this.altitude = altitude;
        this.longitude = longitude;
        this.latitude = latitude;
        this.verticalSpeed = verticalSpeed;
        this.bearing = bearing;
        this.time = time;
    }

    public double getTime() {
        return this.time;
    }

    public void setTime(double time) {
        this.time = time;
    }


    public double getBearing() {
        return this.bearing;
    }

    public void setBearing(double bearing) {
        this.bearing = bearing;
    }

    public double getVerticalSpeed() {
        return verticalSpeed;
    }

    public void setVerticalSpeed(float verticalSpeed) {
        this.verticalSpeed = verticalSpeed;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
