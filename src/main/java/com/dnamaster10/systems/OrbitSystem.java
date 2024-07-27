package com.dnamaster10.systems;

import com.dnamaster10.Drawable;
import com.dnamaster10.Tickable;
import com.dnamaster10.Window;
import com.dnamaster10.objects.Orbit;
import com.dnamaster10.objects.OrbitalBody;
import com.raylib.java.Raylib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.raylib.java.core.Color.WHITE;

public class OrbitSystem implements Tickable, Drawable {
    Raylib rl = Window.getWindow();
    static boolean drawOrbits = true;

    OrbitalBody rootBody;
    List<Orbit> orbitsList = new ArrayList<>();
    HashMap<OrbitalBody, List<Orbit>> orbits = new HashMap<>();

    public OrbitSystem(OrbitalBody rootBody) {
        this.rootBody = rootBody;
    }

    public void addOrbitalBody(OrbitalBody rootBody, OrbitalBody satelliteBody) {
        Orbit orbit = new Orbit(rootBody, satelliteBody);
        if (!orbits.containsKey(rootBody)) {
            orbits.put(rootBody, new ArrayList<>());
        }
        orbits.get(rootBody).add(orbit);
    }

    @Override
    public void draw() {
        if (drawOrbits) {
            for (Orbit orbit : orbitsList) {
                rl.shapes.DrawCircleLines((int) orbit.getX(), (int) orbit.getY(), (int) orbit.getRadius(), WHITE);
            }
        }
    }

    @Override
    public void tick() {
        List<OrbitalBody> tickQueue = new ArrayList<>();
        tickQueue.add(rootBody);
        while (!tickQueue.isEmpty()) {
            if (!orbits.containsKey(tickQueue.getFirst())) {
                tickQueue.removeFirst();
                continue;
            }
            for (Orbit orbit : orbits.get(tickQueue.getFirst())) {
                orbit.tick();
                tickQueue.add(orbit.getSatelliteBody());
            }
            tickQueue.removeFirst();
        }
    }
}
