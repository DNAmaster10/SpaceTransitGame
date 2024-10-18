package com.dnamaster10.scenes;

import com.dnamaster10.Scene;
import com.dnamaster10.Window;
import com.dnamaster10.objects.space.Galaxy;
import com.dnamaster10.systems.CameraManager;
import com.raylib.java.Raylib;

public class GalaxyScene implements Scene {
    private static Raylib rl = Window.getWindow();
    private static CameraManager cameraManager = new CameraManager();

    private Galaxy galaxy;
    public void setGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    @Override
    public void tick() {

    }

    @Override
    public void draw() {

    }
}
