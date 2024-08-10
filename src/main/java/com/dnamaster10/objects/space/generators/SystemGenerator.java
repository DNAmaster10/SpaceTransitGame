package com.dnamaster10.objects.space.generators;

import com.dnamaster10.objects.space.*;
import com.raylib.java.raymath.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SystemGenerator {
    //TODO cleanup code

    private static final Random random = new Random();

    SolarSystem system = new SolarSystem();

    public SolarSystem getRandomSolarSystem() {
        //Generate star
        Star star = getRandomStar();
        star.setPosition(new Vector2(0f, 0f));
        system.setRootStar(star);

        //Generate planets
        int totalPlanets = 0;
        while (random.nextInt(0, 100) > 40) totalPlanets++;
        List<Planet> planets = new ArrayList<>();
        OrbitalBody lastBody = star;
        for (int i = 1; i < totalPlanets + 1; i++) {
            Planet planet = new Planet(getRandomPlanetType(), system);
            float y = lastBody.getY() + lastBody.getSize() + planet.getSize() + 100f + random.nextFloat(0f, 300f);
            Vector2 planetLocation = new Vector2(0f, y);
            planet.setPosition(planetLocation);
            planets.add(planet);
            lastBody = planet;
            system.addOrbitalBody(star, planet);
        }

        //Generate moons
        for (Planet planet : planets) {
            lastBody = planet;
            while (random.nextInt(0, 100) > 80) {
                Moon moon = new Moon(getRandomMoonType(), system);
                float y = lastBody.getY() + lastBody.getSize() + moon.getSize() + 20f + random.nextFloat(0f, 50f);
                Vector2 moonLocation = new Vector2(0f, y);
                moon.setPosition(moonLocation);
                lastBody = moon;
                system.addOrbitalBody(planet, moon);
            }
        }

        return system;
    }

    Star getRandomStar() {
        int age = random.nextInt(0, 1000);
        float mass = random.nextFloat(1000f, 5000f);
        return new Star(mass, age, system);
    }

    Planet.PlanetType getRandomPlanetType() {
        return Planet.PlanetType.values()[random.nextInt(Planet.PlanetType.values().length)];
    }

    Moon.MoonType getRandomMoonType() {
        return Moon.MoonType.values()[random.nextInt(Moon.MoonType.values().length)];
    }
}
