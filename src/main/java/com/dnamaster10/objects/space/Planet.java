package com.dnamaster10.objects.space;

import com.dnamaster10.Drawable;
import com.dnamaster10.Window;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;

import java.util.Random;

import static com.raylib.java.core.Color.*;

public class Planet extends OrbitalBody implements Drawable {
    static Raylib rl = Window.getWindow();
    public enum PlanetType {
        WATER,
        ROCK,
        GAS
    }

    Color color;

    private static final Random random = new Random();
    public Planet(PlanetType planetType) {
        if (planetType == PlanetType.WATER) {
            this.color = BLUE;
            this.setSize(random.nextFloat(10f, 20f));
            this.setMass((getSize() / 1000f) * 1);
        } else if (planetType == PlanetType.ROCK) {
            this.color = GRAY;
            this.setSize(random.nextFloat(10f, 20f));
            this.setMass((getSize() / 1000f) * 1.2f);
        } else if (planetType == PlanetType.GAS) {
            this.color = ORANGE;
            this.setSize(random.nextFloat(50f, 80f));
            this.setMass((getSize() / 1000f) * 0.8f);
        }
    }

    @Override
    public void draw() {
        rl.shapes.DrawCircleV(getLocation(), getSize(), color);
    }
}
