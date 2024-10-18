package com.dnamaster10.objects.space;

import com.dnamaster10.Drawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Galaxy implements Drawable {
    List<SolarSystem> systems = new ArrayList<>();
    public void addSystem(SolarSystem system) {
        systems.add(system);
    }

    HashMap<SolarSystem, List<SolarSystem>> systemConnections = new HashMap<>();
    public void addConnection(SolarSystem system1, SolarSystem system2) {
        if (!systemConnections.containsKey(system1)) systemConnections.put(system1, new ArrayList<>());
        if (!systemConnections.containsKey(system2)) systemConnections.put(system2, new ArrayList<>());

        List<SolarSystem> system1Connections = systemConnections.get(system1);
        List<SolarSystem> system2Connections = systemConnections.get(system2);

        if (!system1Connections.contains(system2)) system1Connections.add(system2);
        if (!system2Connections.contains(system1)) system2Connections.add(system1);
    }

    @Override
    public void draw() {

    }
}
