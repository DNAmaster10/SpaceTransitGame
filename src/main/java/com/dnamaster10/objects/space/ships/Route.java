package com.dnamaster10.objects.space.ships;

import com.dnamaster10.Tickable;
import com.dnamaster10.objects.space.ships.waypoints.Waypoint;
import com.raylib.java.raymath.Vector2;

import java.util.List;

public class Route implements Tickable {
    List<Waypoint> waypoints;
    Ship ship;

    public Route(List<Waypoint> waypoints, Ship ship) {
        this.waypoints = waypoints;
        this.ship = ship;
    }

    public boolean completed() {
        return this.waypoints.isEmpty();
    }

    public void addWaypoint(Waypoint waypoint) {
        this.waypoints.add(waypoint);
    }

    @Override
    public void tick() {
        if (waypoints.isEmpty()) return;
        Waypoint first = waypoints.getFirst();
        Vector2 shipPosition = ship.getPosition();
        first.update(shipPosition);
        if (first.hasReached(shipPosition)) waypoints.removeFirst();
    }
}
