package com.dnamaster10.scenes;

import com.dnamaster10.Scene;
import com.dnamaster10.Window;
import com.dnamaster10.objects.space.SolarSystem;
import com.dnamaster10.objects.space.Star;
import com.dnamaster10.objects.space.SystemGenerator;
import com.dnamaster10.systems.CameraSystem;
import com.raylib.java.Raylib;
import com.raylib.java.raymath.Vector2;

import java.util.ArrayList;
import java.util.List;

import static com.raylib.java.core.Color.*;
import static com.raylib.java.core.input.Keyboard.KEY_SPACE;

public class MainGame implements Scene {
    public static final float GRAVITY_CONSTANT = 0.0009f;
    static Raylib rl = Window.getWindow();
    CameraSystem cameraSystem = new CameraSystem();

    SolarSystem solarSystem = new SystemGenerator().getRandomSolarSystem();

    @Override
    public void tick() {
        cameraSystem.tick();
        solarSystem.tick();

        if (rl.core.IsKeyPressed(KEY_SPACE)) {
            solarSystem = new SystemGenerator().getRandomSolarSystem();
        }
    }

    @Override
    public void draw() {
        rl.core.BeginDrawing();
        rl.core.ClearBackground(BLACK);
        rl.core.BeginMode2D(cameraSystem.getCamera());
        solarSystem.draw();
        rl.core.EndMode2D();
        rl.text.DrawFPS(10, 10);
        rl.core.EndDrawing();
    }
}
