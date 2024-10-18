package com.dnamaster10.systems;

import com.dnamaster10.Tickable;
import com.dnamaster10.objects.space.stations.Station;

import java.util.ArrayList;
import java.util.List;

public class StationManager implements Tickable {
    List<Station> stations = new ArrayList<>();

    @Override
    public void tick() {
        for (Station station : stations) station.tick();
    }

    public List<Station> getStations() {
        return stations;
    }

    public void addStation(Station station) {
        stations.add(station);
    }
}
