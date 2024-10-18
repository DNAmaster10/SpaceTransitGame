package com.dnamaster10.objects.space.ships.pathfinding;

import com.dnamaster10.objects.space.stations.Dock;
import com.raylib.java.raymath.Raymath;
import com.raylib.java.raymath.Vector2;

public class DockWaypoint implements Waypoint {
    Dock dock;

    public DockWaypoint(Dock dock) {
        this.dock = dock;
    }

    @Override
    public boolean hasReached(Vector2 shipPosition) {
        return Raymath.Vector2Distance(shipPosition, dock.getPosition()) < 1f;
    }

    @Override
    public Vector2 getPosition() {
        return dock.getPosition();
    }
}
