package com.dnamaster10.objects.space;

import com.dnamaster10.Window;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;

import java.util.Random;

import static com.raylib.java.core.Color.BROWN;
import static com.raylib.java.core.Color.GRAY;

public class Moon extends OrbitalBody {
    static Raylib rl = Window.getWindow();
    public enum MoonType {
        ROCKY,
        IRON
    }

    Color color;

    private static final Random random = new Random();
    public Moon(MoonType moonType) {
        if (moonType == MoonType.IRON) {
            color = BROWN;
            setSize(random.nextFloat(1, 3));
            setMass((getSize() / 1000f) * 1.4f);
        } else if (moonType == MoonType.ROCKY) {
            color = GRAY;
            setSize(random.nextFloat(1, 3));
            setMass((getSize() / 1000f) * 1.2f);
        }
    }

    @Override
    public void draw() {
        rl.shapes.DrawCircleV(getLocation(), getSize(), color);
    }
}
