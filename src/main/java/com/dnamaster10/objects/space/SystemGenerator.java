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

        //Generate planets
        int totalPlanets = random.nextInt(0, 10);
        List<Vector2> planetLocations = new ArrayList<>();
        int currentY = (int) (star.getSize() + 200);
        for ()
    }

    Star getRandomStar() {
        int age = random.nextInt(0, 1000);
        float mass = random.nextFloat(0.005f, 0.05f);
        return new Star(mass, age);
    }

    Planet.PlanetType getRandomPlanetType() {
        return Planet.PlanetType.values()[random.nextInt(Planet.PlanetType.values().length)];
    }
}
