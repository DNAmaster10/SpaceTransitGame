package com.dnamaster10.objects.space;

import com.dnamaster10.Window;
import com.dnamaster10.objects.Positionable;
import com.dnamaster10.objects.SystemObject;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;

import java.util.Random;

import static com.raylib.java.core.Color.BROWN;
import static com.raylib.java.core.Color.GRAY;

public class Moon extends OrbitalBody implements SystemObject {
    static Raylib rl = Window.getWindow();

    public enum MoonType {
        ROCKY,
        IRON
    }

    //References
    SolarSystem system;

    Color color;

    private static final Random random = new Random();
    public Moon(MoonType moonType, SolarSystem system) {
        if (moonType == MoonType.IRON) {
            color = BROWN;
            setSize(random.nextFloat(1, 3));
            setMass((getSize() / 1000f) * 1.4f);
        } else if (moonType == MoonType.ROCKY) {
            color = GRAY;
            setSize(random.nextFloat(1, 3));
            setMass((getSize() / 1000f) * 1.2f);
        }
        this.system = system;
    }

    @Override
    public void draw() {
        rl.shapes.DrawCircleV(getPosition(), getSize(), color);
    }

    @Override
    public SolarSystem getSystem() {
        return this.system;
    }
}
