package com.dnamaster10.objects.space;

import com.dnamaster10.Window;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;

import static com.raylib.java.core.Color.BROWN;
import static com.raylib.java.core.Color.GRAY;

public class Moon extends OrbitalBody {
    static Raylib rl = Window.getWindow();
    public enum MoonType {
        ROCKY,
        IRON
    }

    Color color;

    public Moon(MoonType moonType, Vector2 location) {
        if (moonType == MoonType.IRON) {
            color = BROWN;
        } else if (moonType == MoonType.ROCKY) {
            color = GRAY;
        }

        super.setLocation(location);
        super.setSize(5f);
        super.setMass(0.005f);
    }

    @Override
    public void draw() {
        rl.shapes.DrawCircleV(getLocation(), getSize(), color);
    }
}
