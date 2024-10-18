package com.dnamaster10.objects.space;

import com.raylib.java.raymath.Vector2;

public interface OrbitalBody {
    float getX();
    float getY();
    void setX(float x);
    void setY(float y);
    void setPosition(Vector2 position);
    Vector2 getPosition();
    void setMass(float mass);
    float getMass();
    void setSize(float size);
    float getSize();
}