package com.dnamaster10.objects.space;

import com.dnamaster10.Drawable;
import com.dnamaster10.Tickable;
import com.dnamaster10.systems.OrbitSystem;
import com.raylib.java.raymath.Vector2;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem implements Tickable, Drawable {
    OrbitalBody rootBody;
    OrbitSystem orbitSystem;
    List<OrbitalBody> orbitalBodies = new ArrayList<>();

    public SolarSystem(OrbitalBody rootBody) {
        this.rootBody = rootBody;
        orbitSystem = new OrbitSystem(rootBody);
        orbitalBodies.add(rootBody);
    }

    public void setRootBody(OrbitalBody rootBody) {
        this.rootBody = rootBody;
    }

    public void addOrbitalBody(OrbitalBody rootBody, OrbitalBody satelliteBody) {
        if (!orbitalBodies.contains(satelliteBody)) {
            orbitalBodies.add(satelliteBody);
        }
        orbitSystem.addOrbitalBody(rootBody, satelliteBody);
    }

    public void generate() {
        Planet planet1 = new Planet(Planet.PlanetType.ROCK, new Vector2(600f, 500f));
        Planet planet2 = new Planet(Planet.PlanetType.WATER, new Vector2(700f, 500f));
        Moon moon1 = new Moon(Moon.MoonType.IRON, new Vector2(750f, 500f));
        Moon moon2 = new Moon(Moon.MoonType.ROCKY, new Vector2(765f, 500f));
        Planet planet3 = new Planet(Planet.PlanetType.ROCK, new Vector2(850f, 550f));
        Moon moon3 = new Moon(Moon.MoonType.IRON, new Vector2(850f, 570f));

        orbitSystem.addOrbitalBody(rootBody, planet1);
        orbitSystem.addOrbitalBody(rootBody, planet2);
        orbitSystem.addOrbitalBody(planet2, moon1);
        orbitSystem.addOrbitalBody(planet2, moon2);
        orbitSystem.addOrbitalBody(rootBody, planet3);
        orbitSystem.addOrbitalBody(planet3, moon3);

        orbitalBodies.add(planet1);
        orbitalBodies.add(planet2);
        orbitalBodies.add(moon1);
        orbitalBodies.add(moon2);
        orbitalBodies.add(planet3);
        orbitalBodies.add(moon3);
    }

    @Override
    public void draw() {
        orbitSystem.draw();
        for (OrbitalBody orbitalBody : orbitalBodies) {
            orbitalBody.draw();
        }
    }

    @Override
    public void tick() {
        orbitSystem.tick();
    }
}
