package com.dnamaster10.objects.space.stations;

import com.dnamaster10.objects.Positionable;
import com.raylib.java.raymath.Vector2;

public class WaitingPoint implements Positionable {
    Vector2 position;

    public WaitingPoint(Vector2 position) {
        this.position = position;
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    public void setX(float x) {
        this.position.setX(x);
    }

    public void setY(float y) {
        this.position.setY(y);
    }
}
