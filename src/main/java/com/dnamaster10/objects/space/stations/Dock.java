package com.dnamaster10.objects.space.stations;

import com.dnamaster10.objects.Positionable;
import com.dnamaster10.objects.StationObject;
import com.dnamaster10.objects.SystemObject;
import com.dnamaster10.objects.space.SolarSystem;
import com.raylib.java.raymath.Vector2;

public class Dock implements Positionable, SystemObject, StationObject {

    //References
    Station station;

    Vector2 position;
    boolean reserved = false;
    boolean occupied = false;

    public Dock(Vector2 position, Station station) {
        this.position = position;
        this.station = station;
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public void setX(float x) {
        this.position.setX(x);
    }

    public void setY(float y) {
        this.position.setY(y);
    }

    public boolean isAvailable() {
        return !reserved && !occupied;
    }

    @Override
    public SolarSystem getSystem() {
        return station.getSystem();
    }

    @Override
    public Station getStation() {
        return station;
    }
}
