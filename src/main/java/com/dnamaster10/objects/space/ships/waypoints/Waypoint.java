package com.dnamaster10.objects.space.ships.waypoints;

import com.raylib.java.raymath.Vector2;

public interface Waypoint {
    public abstract boolean hasReached(Vector2 shipPosition);
    public abstract Vector2 getPosition();
    public abstract void update(Vector2 shipPosition);
}