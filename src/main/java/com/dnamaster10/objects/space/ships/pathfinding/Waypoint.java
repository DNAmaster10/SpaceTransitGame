package com.dnamaster10.objects.space.ships.pathfinding;

import com.raylib.java.raymath.Vector2;

public interface Waypoint {
    boolean hasReached(Vector2 shipPosition);
    Vector2 getPosition();
}