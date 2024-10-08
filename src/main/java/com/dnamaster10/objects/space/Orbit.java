package com.dnamaster10.objects.space;

import com.dnamaster10.Tickable;
import com.dnamaster10.util.MathUtils;
import com.dnamaster10.Window;
import com.raylib.java.raymath.Vector2;

public class Orbit implements Tickable {
    OrbitalBody centerBody;
    OrbitalBody satelliteBody;
    double radius;
    double speed;
    private double orbitalAngle = 0;

    public Orbit(OrbitalBody rootBody, OrbitalBody satelliteBody) {
        this.centerBody = rootBody;
        this.satelliteBody = satelliteBody;
        double dx = Math.abs(rootBody.getX() - satelliteBody.getX());
        double dy = Math.abs(rootBody.getY() - satelliteBody.getY());
        this.radius = Math.sqrt((dx * dx) + (dy * dy));
        this.speed = MathUtils.getOrbitalVelocity(rootBody.getMass(), radius);
    }

    @Override
    public void tick() {
        orbitalAngle += (speed * Window.getWindow().core.GetFrameTime());
        while (orbitalAngle > 360) {
            orbitalAngle = orbitalAngle - 360;
        }
        float orbitalRadians = (float) Math.toRadians(orbitalAngle);

        satelliteBody.setX(centerBody.getX() + (float) (Math.cos(orbitalRadians) * radius));
        satelliteBody.setY(centerBody.getY() + (float) (Math.sin(orbitalRadians) * radius));
    }

    public OrbitalBody getSatelliteBody() {
        return this.satelliteBody;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getX() {
        return centerBody.getX();
    }

    public double getY() {
        return centerBody.getY();
    }
}
