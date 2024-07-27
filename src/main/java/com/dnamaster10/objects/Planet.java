package com.dnamaster10.objects;

import com.dnamaster10.Drawable;
import com.dnamaster10.Window;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;

import static com.raylib.java.core.Color.BLUE;
import static com.raylib.java.core.Color.GRAY;

public class Planet extends OrbitalBody implements Drawable {
    static Raylib rl = Window.getWindow();
    public enum PlanetType {
        WATER,
        ROCK
    }

    Color color;

    public Planet(PlanetType planetType, Vector2 location) {
        if (planetType == PlanetType.WATER) {
            this.color = BLUE;
        } else if (planetType == PlanetType.ROCK) {
            this.color = GRAY;
        }

        super.setLocation(location);
        super.setSize(20f);
        super.setMass(0.01f);
    }

    @Override
    public void draw() {
        rl.shapes.DrawCircleV(getLocation(), getSize(), color);
    }
}
