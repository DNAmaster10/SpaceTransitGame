package com.dnamaster10.objects.space.ships.waypoints;

import com.dnamaster10.objects.SystemObject;
import com.dnamaster10.objects.space.SolarSystem;
import com.raylib.java.raymath.Vector2;

public class JumpWaypoint implements Waypoint, SystemObject {

    SolarSystem sourceSystem;
    SolarSystem destinationSystem;

    public JumpWaypoint(SolarSystem sourceSystem, SolarSystem destinationSystem) {
        this.sourceSystem = sourceSystem;
        this.destinationSystem = destinationSystem;
    }

    @Override
    public boolean hasReached(Vector2 shipPosition) {
        return true;
    }

    @Override
    public Vector2 getPosition() {
        return null;
    }

    @Override
    public void update(Vector2 shipPosition) {

    }

    @Override
    public SolarSystem getSystem() {
        return null;
    }
}
