package com.dnamaster10.systems;

import com.dnamaster10.objects.space.ships.Route;
import com.dnamaster10.objects.space.ships.Ship;
import com.dnamaster10.objects.space.ships.waypoints.StationWaypoint;
import com.dnamaster10.objects.space.ships.waypoints.Waypoint;
import com.dnamaster10.objects.space.stations.Station;

import java.util.ArrayList;
import java.util.List;

public class RouteManager {

    public Route getNewRoute(Ship ship, Station station) {
        List<Waypoint> waypoints = new ArrayList<>();
        if (ship.getCurrentSystem() == station.getSystem()) {
            waypoints.add(new StationWaypoint(station));
            return new Route(waypoints, ship);
        }
    }
}
