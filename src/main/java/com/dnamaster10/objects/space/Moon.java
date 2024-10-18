package com.dnamaster10.objects.space;

import com.dnamaster10.Drawable;
import com.dnamaster10.Window;
import com.dnamaster10.objects.Positionable;
import com.dnamaster10.objects.SystemObject;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;

import java.util.Random;

import static com.raylib.java.core.Color.BROWN;
import static com.raylib.java.core.Color.GRAY;

public class Moon implements SystemObject, Drawable, OrbitalBody, Positionable {
    static Raylib rl = Window.getWindow();

    public enum MoonType {
        ROCKY,
        IRON
    }

    //References
    SolarSystem system;

    Color color;
    Vector2 position = new Vector2();
    float mass;
    float size;

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

    @Override
    public float getX() {
        return position.x;
    }

    @Override
    public float getY() {
        return position.y;
    }

    @Override
    public void setX(float x) {
        position.x = x;
    }

    @Override
    public void setY(float y) {
        position.y = y;
    }

    @Override
    public void setPosition(Vector2 position) {
        this.position.x = position.x;
        this.position.y = position.y;
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public void setMass(float mass) {
        this.mass = mass;
    }

    @Override
    public float getMass() {
        return mass;
    }

    @Override
    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public float getSize() {
        return size;
    }
}
