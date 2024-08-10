package com.dnamaster10.objects.space.ships.waypoints;

import com.dnamaster10.objects.space.SolarSystem;
import com.raylib.java.raymath.Raymath;
import com.raylib.java.raymath.Vector2;

public class SystemWaypoint implements Waypoint {
    Vector2 position;

    public SystemWaypoint(Vector2 position) {
        this.position = position;
    }

    @Override
    public boolean hasReached(Vector2 shipPosition) {
        return Raymath.Vector2Distance(shipPosition, position) < 1f;
    }

    @Override
    public Vector2 getPosition() {
        return this.position;
    }

    @Override
    public void update(Vector2 shipPosition) {}
}
