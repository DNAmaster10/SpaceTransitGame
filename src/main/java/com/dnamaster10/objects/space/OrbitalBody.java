package com.dnamaster10.objects.space;

import com.dnamaster10.Drawable;
import com.dnamaster10.objects.Positionable;
import com.dnamaster10.objects.SystemObject;
import com.raylib.java.raymath.Vector2;

public abstract class OrbitalBody implements Drawable, Positionable {
    Vector2 position = new Vector2();
    float mass;
    float size;

    public float getX() {
        return position.getX();
    }

    public float getY() {
        return position.getY();
    }

    public void setX(float x) {
        position.setX(x);
    }

    public void setY(float y) {
        position.setY(y);
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getMass() {
        return this.mass;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getSize() {
        return this.size;
    }
}
