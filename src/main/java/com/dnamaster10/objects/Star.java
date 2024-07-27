package com.dnamaster10.objects;

import com.dnamaster10.Window;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;

import static com.raylib.java.core.Color.GREEN;

public class Star extends OrbitalBody {
    static Raylib rl = Window.getWindow();
    int age;
    Color color;


    public Star(Vector2 location, float mass, int age) {
        float size = 0;
        this.age = age;

        if (mass < 900 && mass > 300) {
            size = mass / 10;
        } else if (mass <= 300) {
            size = 300f / 10;
        }

        int colourChangeAmount = (int) (765f / ( 1000f / age));
        if (colourChangeAmount <= 255) {
            this.color = new Color(colourChangeAmount, colourChangeAmount, 255, 255);
        } else if (colourChangeAmount <= 510) {
            int yellowAmount = colourChangeAmount - 255;
            this.color = new Color(255, 255, 255 - yellowAmount, 255);
        } else {
            int redAmount = colourChangeAmount - 510;
            this.color = new Color(255, 255 - redAmount, 0, 255);
        }

        if (mass > 900) {
            this.color = new Color(0, 0, 0, 255);
        }

        super.setLocation(location);
        super.size = size;
        super.mass = 0.01f;
    }

    @Override
    public void draw() {
        rl.shapes.DrawCircleV(getLocation(), getSize(), color);
    }
}
