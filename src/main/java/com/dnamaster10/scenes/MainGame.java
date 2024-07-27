package com.dnamaster10.scenes;

import com.dnamaster10.Scene;
import com.dnamaster10.Window;
import com.dnamaster10.objects.space.SolarSystem;
import com.dnamaster10.objects.space.Star;
import com.dnamaster10.systems.CameraSystem;
import com.raylib.java.Raylib;
import com.raylib.java.raymath.Vector2;

import java.util.ArrayList;
import java.util.List;

import static com.raylib.java.core.Color.*;

public class MainGame implements Scene {
    public static final float GRAVITY_CONSTANT = 0.0001f;
    static Raylib rl = Window.getWindow();
    Star rootBody = new Star(new Vector2(500f, 500f), 200, 400);
    SolarSystem solarSystem = new SolarSystem(rootBody);
    CameraSystem cameraSystem = new CameraSystem();

    public void generate() {
        solarSystem.generate();
    }

    List<Star> stars = new ArrayList<>();
    @Override
    public void tick() {
        cameraSystem.tick();
        solarSystem.tick();
    }

    @Override
    public void draw() {
        rl.core.BeginDrawing();
        rl.core.ClearBackground(BLACK);
        rl.core.BeginMode2D(cameraSystem.getCamera());
        solarSystem.draw();
        rl.core.EndMode2D();
        rl.text.DrawText("Zoom: " + cameraSystem.getCamera().getZoom(), 10, 10, 50, WHITE);
        rl.core.EndDrawing();
    }
}
