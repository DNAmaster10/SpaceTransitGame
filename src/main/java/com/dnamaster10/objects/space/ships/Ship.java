package com.dnamaster10.objects.space.ships;

import com.dnamaster10.Drawable;
import com.dnamaster10.Tickable;
import com.dnamaster10.Window;
import com.dnamaster10.objects.Positionable;
import com.dnamaster10.objects.space.SolarSystem;
import com.dnamaster10.objects.space.ships.pathfinding.SystemWaypoint;
import com.dnamaster10.objects.space.ships.pathfinding.Waypoint;
import com.dnamaster10.objects.space.stations.Dock;
import com.raylib.java.Raylib;
import com.raylib.java.raymath.Raymath;
import com.raylib.java.raymath.Vector2;

import static com.raylib.java.core.Color.RED;
import static com.raylib.java.core.Color.WHITE;
import static com.raylib.java.core.input.Mouse.MouseButton.MOUSE_BUTTON_LEFT;

public class Ship implements Tickable, Drawable, Positionable {
    private final Raylib rl = Window.getWindow();

    //References
    SolarSystem currentSystem;

    //Rotations in radians
    float rotation = 0f;
    float goalRotation = 0f;

    Vector2 position;
    Float speed = 10f;
    float maxAcceleration = 50f;
    float maxDeceleration = 100f;

    //Pathfinding
    Route route = new Route(this);
    boolean docked = false;
    Dock currentDock = null;

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
        route.draw();
    }

    @Override
    public void tick() {
        if (rl.core.IsMouseButtonPressed(MOUSE_BUTTON_LEFT.ordinal())) {
            Vector2 position = rl.core.GetScreenToWorld2D(rl.core.GetMousePosition(), getCameraManager().getCamera());
            SystemWaypoint waypoint = new SystemWaypoint(position);
            route.addWaypoint(waypoint);
        }

        if (docked) {
            this.position = currentDock.getPosition();
            return;
        }
        else if (route.completed()) return;
        Waypoint nextWaypoint = route.getNext();
        position = Raymath.Vector2MoveTowards(position, nextWaypoint.getPosition(), 10f);
        if (nextWaypoint.hasReached(position)) {
            route.tick();
        }
    }

    private void move() {

    }

    public Vector2 getPosition() {
        return this.position;
    }

    public SolarSystem getCurrentSystem() {
        return this.currentSystem;
    }
}
