package com.dnamaster10.objects.space.ships.waypoints;

import com.dnamaster10.objects.space.stations.Station;
import com.raylib.java.raymath.Raymath;
import com.raylib.java.raymath.Vector2;

public class StationWaypoint implements Waypoint {
    Station station;
    Vector2 position;

    public StationWaypoint(Station station) {
        this.station = station;
    }

    @Override
    public boolean hasReached(Vector2 shipPosition) {
        return Raymath.Vector2Distance(shipPosition, station.getPosition()) < 10f;
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public void update(Vector2 shipPosition) {
        this.position = Raymath.Vector2MoveTowards(station.getPosition(), shipPosition, 10f);
    }
}
