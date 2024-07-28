package com.dnamaster10.objects.space;

import com.raylib.java.raymath.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SystemGenerator {
    private static final Random random = new Random();
    public SolarSystem getRandomSolarSystem() {
        //Generate star
        Star star = getRandomStar();
        star.setLocation(new Vector2(0f, 0f));
        SolarSystem solarSystem = new SolarSystem(star);

        //Generate planets
        int totalPlanets = 0;
        while (random.nextInt(0, 100) > 40) totalPlanets++;
        List<Planet> planets = new ArrayList<>();
        OrbitalBody lastBody = star;
        for (int i = 1; i < totalPlanets + 1; i++) {
            Planet planet = new Planet(getRandomPlanetType());
            float y = lastBody.getY() + lastBody.getSize() + planet.getSize() + 100f + random.nextFloat(0f, 300f);
            Vector2 planetLocation = new Vector2(0f, y);
            planet.setLocation(planetLocation);
            planets.add(planet);
            lastBody = planet;
            solarSystem.addOrbitalBody(star, planet);
        }

        //Generate moons
        for (Planet planet : planets) {
            lastBody = planet;
            while (random.nextInt(0, 100) > 80) {
                Moon moon = new Moon(getRandomMoonType());
                float y = lastBody.getY() + lastBody.getSize() + moon.getSize() + 20f + random.nextFloat(0f, 50f);
                Vector2 moonLocation = new Vector2(0f, y);
                moon.setLocation(moonLocation);
                lastBody = moon;
                solarSystem.addOrbitalBody(planet, moon);
            }
        }

        return solarSystem;
    }

    Star getRandomStar() {
        int age = random.nextInt(0, 1000);
        float mass = random.nextFloat(0.005f, 0.05f);
        return new Star(mass, age);
    }

    Planet.PlanetType getRandomPlanetType() {
        return Planet.PlanetType.values()[random.nextInt(Planet.PlanetType.values().length)];
    }

    Moon.MoonType getRandomMoonType() {
        return Moon.MoonType.values()[random.nextInt(Moon.MoonType.values().length)];
    }
}
