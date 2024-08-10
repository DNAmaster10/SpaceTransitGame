package com.dnamaster10.objects.space.stations;

import com.dnamaster10.Drawable;
import com.dnamaster10.objects.SystemObject;
import com.dnamaster10.objects.space.OrbitalBody;
import com.dnamaster10.objects.space.SolarSystem;
import com.raylib.java.raymath.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Station extends OrbitalBody implements Drawable, SystemObject {

    //References
    SolarSystem system;

    Vector2 position;
    List<Dock> docks = new ArrayList<>();

    public Station(Vector2 position, SolarSystem system) {
        this.position = position;
        this.system = system;
    }

    public boolean checkFreeDock() {
        for (Dock dock : docks) {
            if (dock.isAvailable()) return true;
        }
        return false;
    }

    public Dock getAvailableDock() {
        for (Dock dock : docks) {
            if (dock.isAvailable()) return dock;
        }
        return null;
    }

    @Override
    public void draw() {

    }

    @Override
    public SolarSystem getSystem() {
        return this.system;
    }
}