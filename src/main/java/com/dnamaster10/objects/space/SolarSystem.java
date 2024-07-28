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
