package com.dnamaster10.objects.space.ships;

import com.dnamaster10.Tickable;
import com.dnamaster10.Window;
import com.dnamaster10.objects.space.ships.pathfinding.Waypoint;
import com.raylib.java.Raylib;
import com.raylib.java.raymath.Raymath;
import com.raylib.java.raymath.Vector2;

import java.util.ArrayList;
import java.util.List;

import static com.raylib.java.core.Color.GREEN;

public class Route implements Tickable {
    private static final Raylib rl = Window.getWindow();
    List<Waypoint> waypoints;
    Ship ship;

    public Route(Ship ship) {
        this.waypoints = new ArrayList<>();
        this.ship = ship;
    }

    public boolean completed() {
        return this.waypoints.isEmpty();
    }

    public void addWaypoint(Waypoint waypoint) {
        this.waypoints.add(waypoint);
    }

    public Waypoint getNext() {
        return waypoints.getFirst();
    }

    @Override
    public void tick() {
        if (waypoints.isEmpty()) return;
        Waypoint first = waypoints.getFirst();
        Vector2 shipPosition = ship.getPosition();
        if (first.hasReached(shipPosition)) waypoints.removeFirst();
    }

    public void draw() {
        for (Waypoint waypoint : waypoints) {
            rl.shapes.DrawCircle((int) waypoint.getPosition().x, (int) waypoint.getPosition().y, 1f, GREEN);
        }
    }
}
