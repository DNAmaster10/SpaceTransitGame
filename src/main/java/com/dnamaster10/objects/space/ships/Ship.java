package com.dnamaster10.objects.space.ships;

import com.dnamaster10.Drawable;
import com.dnamaster10.Tickable;
import com.dnamaster10.Window;
import com.dnamaster10.objects.Positionable;
import com.dnamaster10.objects.space.SolarSystem;
import com.dnamaster10.objects.space.stations.Station;
import com.raylib.java.Raylib;
import com.raylib.java.raymath.Raymath;
import com.raylib.java.raymath.Vector2;

import static com.raylib.java.core.Color.RED;
import static com.raylib.java.core.Color.WHITE;

public class Ship implements Tickable, Drawable, Positionable {
    private Raylib rl = Window.getWindow();

    //References
    SolarSystem currentSystem;

    //Rotations in radians
    float rotation = 0f;
    float goalRotation = 0f;

    Vector2 position;
    Float speed = 0f;
    Positionable goal;
    float maxAcceleration = 50f;
    float maxDeceleration = 100f;

    Station destination;
    boolean docked = false;

    Vector2 goalLineEnd = new Vector2(0f, 0f);
    Vector2 rotationLineEnd = new Vector2(0f, 0f);

    public Ship(float x, float y, SolarSystem system) {
        this.position = new Vector2(x, y);
        this.currentSystem = system;
    }

    @Override
    public void draw() {
        rl.shapes.DrawCircleV(position, 10, WHITE);
        rl.shapes.DrawLineV(position, goalLineEnd, WHITE);
        rl.shapes.DrawLineV(position, rotationLineEnd, RED);
        rl.text.DrawText("Position: " + position.getX() + "," + position.getY(), 10, 0, 20, WHITE);
        rl.text.DrawText("Current Rotation: " + rotation, 10, 50, 20, WHITE);
        rl.text.DrawText("Goal Rotation: " + goalRotation, 10, 100, 20, WHITE);
        rl.text.DrawText("Rotation Line: " + rotationLineEnd.getX() + "," + rotationLineEnd.getY(), 10, 150, 20, WHITE);
        rl.text.DrawText("Speed: " + speed, 10, 350, 20, WHITE);
    }

    @Override
    public void tick() {
        Vector2 goalRotationVector = Raymath.Vector2MoveTowards(position, goal, 1);
        goalRotation = (float) Math.atan2(goalRotationVector.getY() - position.getY(), goalRotationVector.getX() - position.getX());
        if (goalRotation < -Math.PI) goalRotation += (float) (2 * Math.PI);
        else if (goalRotation >= Math.PI) rotation -= (float) (2 * Math.PI);

        goalLineEnd.setX(position.getX() + (float) ((Math.cos(goalRotation) * 20)));
        goalLineEnd.setY(position.getY() + (float) ((Math.sin(goalRotation) * 20)));

        float deltaRotation = goalRotation - rotation;

        if (Math.abs(deltaRotation) > 0.1f) {
            if (deltaRotation < -Math.PI) deltaRotation += (float) (2 * Math.PI);
            else if (deltaRotation >= Math.PI) deltaRotation -= (float) (2 * Math.PI);

            if (deltaRotation > 0) rotation += 0.1f;
            else rotation -= 0.1f;
        }

        if (rotation < -Math.PI) rotation += (float) (2 * Math.PI);
        else if (rotation >= Math.PI) rotation -= (float) (2 * Math.PI);

        rotationLineEnd.setX(position.getX() + (float) (200 * Math.cos(rotation)));
        rotationLineEnd.setY(position.getY() + (float) (200 * Math.sin(rotation)));

        move();
    }

    private void move() {
        float distance = Raymath.Vector2Distance(position, goal);
        if (distance < 1) {
            speed = 0f;
            return;
        }
        float stoppingDistance = (speed * speed) / (2 * maxDeceleration);

        if (stoppingDistance >= distance) {
            speed -= maxDeceleration * rl.core.GetFrameTime();
            if (speed < 0f) speed = 0f;
        } else {
            speed += maxAcceleration * rl.core.GetFrameTime();
        }

        position = Raymath.Vector2MoveTowards(position, goal, speed * rl.core.GetFrameTime());
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public SolarSystem getCurrentSystem() {
        return this.currentSystem;
    }
}
