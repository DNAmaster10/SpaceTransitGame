package com.dnamaster10.scenes;

import com.dnamaster10.Scene;
import com.dnamaster10.Window;
import com.dnamaster10.objects.space.SolarSystem;
import com.dnamaster10.objects.space.generators.SystemGenerator;
import com.dnamaster10.objects.space.ships.Ship;
import com.dnamaster10.systems.CameraManager;
import com.raylib.java.Raylib;

import static com.raylib.java.core.Color.*;
import static com.raylib.java.core.input.Keyboard.KEY_SPACE;

public class SystemScene implements Scene {
    public static final float GRAVITY_CONSTANT = 100000f;
    static Raylib rl = Window.getWindow();
    private static CameraManager cameraManager = new CameraManager();

    SolarSystem solarSystem = new SystemGenerator().getRandomSolarSystem();

    public CameraManager getCameraManager() {
        return cameraManager;
    }

    Ship ship = new Ship(0f, 0f, solarSystem);

    @Override
    public void tick() {
        cameraManager.tick();
        solarSystem.tick();

        if (rl.core.IsKeyPressed(KEY_SPACE)) {
            solarSystem = new SystemGenerator().getRandomSolarSystem();
        }
        ship.tick();
    }

    @Override
    public void draw() {
        rl.core.BeginDrawing();
        rl.core.ClearBackground(BLACK);
        rl.core.BeginMode2D(cameraManager.getCamera());
        solarSystem.draw();
        ship.draw();
        rl.core.EndMode2D();
        rl.text.DrawFPS(10, 10);
        rl.core.EndDrawing();
    }
}
