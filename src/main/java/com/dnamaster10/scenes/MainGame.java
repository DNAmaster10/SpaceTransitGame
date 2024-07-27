package com.dnamaster10.scenes;

import com.dnamaster10.Scene;
import com.dnamaster10.Window;
import com.dnamaster10.objects.SolarSystem;
import com.dnamaster10.objects.Star;
import com.raylib.java.Raylib;
import com.raylib.java.raymath.Vector2;

import java.util.ArrayList;
import java.util.List;

import static com.raylib.java.core.Color.BLACK;
import static com.raylib.java.core.Color.GREEN;

public class MainGame implements Scene {
    public static final float GRAVITY_CONSTANT = 0.0001f;
    static Raylib rl = Window.getWindow();
    Star rootBody = new Star(new Vector2(500f, 500f), 200, 400);
    SolarSystem solarSystem = new SolarSystem(rootBody);

    public void generate() {
        solarSystem.generate();
    }

    List<Star> stars = new ArrayList<>();
    @Override
    public void tick() {
        solarSystem.tick();
    }

    @Override
    public void draw() {
        rl.core.BeginDrawing();
        rl.core.ClearBackground(BLACK);
        solarSystem.draw();
        Vector2 location = rootBody.getLocation();
        rl.text.DrawText("Root Location: " + location.x + "," + location.y, 10, 10, 10, GREEN);
        rl.core.EndDrawing();
    }
}
