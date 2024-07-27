package com.dnamaster10.objects;

import com.dnamaster10.Drawable;
import com.raylib.java.raymath.Vector2;

public abstract class OrbitalBody implements Drawable {
    Vector2 location = new Vector2();
    float mass;
    float size;

    public float getX() {
        return location.getX();
    }

    public float getY() {
        return location.getY();
    }

    public void setX(float x) {
        location.setX(x);
    }

    public void setY(float y) {
        location.setY(y);
    }

    public void setLocation(Vector2 location) {
        this.location = location;
    }

    public Vector2 getLocation() {
        return this.location;
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
