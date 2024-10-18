package com.dnamaster10.objects.space;

import com.dnamaster10.Drawable;
import com.dnamaster10.Tickable;
import com.dnamaster10.Window;
import com.dnamaster10.objects.space.stations.Station;
import com.dnamaster10.systems.OrbitManager;
import com.dnamaster10.systems.ShaderManager;
import com.dnamaster10.systems.StationManager;
import com.raylib.java.Raylib;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem implements Tickable, Drawable {
    Raylib rl = Window.getWindow();

    Star rootStar;
    OrbitManager orbitManager;
    StationManager stationManager = new StationManager();
    List<Star> stars = new ArrayList<>();
    List<Planet> planets = new ArrayList<>();
    List<Moon> moons = new ArrayList<>();

    public void setRootStar(Star star) {
        this.rootStar = star;
        orbitManager = new OrbitManager(star);
        stars.add(star);
    }

    public void addOrbitalBody(OrbitalBody rootBody, OrbitalBody satelliteBody) {
        orbitManager.addOrbitalBody(rootBody, satelliteBody);

        if (satelliteBody instanceof Star s) stars.add(s);
        else if (satelliteBody instanceof Planet p) planets.add(p);
        else if (satelliteBody instanceof Moon m) moons.add(m);
        else if (satelliteBody instanceof Station s) stationManager.addStation(s);
    }


    @Override
    public void draw() {
        orbitManager.draw();

        rl.core.BeginShaderMode(ShaderManager.STAR_SHADER);
        for (Star star : stars) star.draw();
        rl.core.EndShaderMode();

        for (Planet planet : planets) planet.draw();
        for (Moon moon : moons) moon.draw();
        for (Station station : stationManager.getStations()) station.draw();
    }

    @Override
    public void tick() {
        orbitManager.tick();
        stationManager.tick();
    }
}
