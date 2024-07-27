package com.dnamaster10.objects;

import com.dnamaster10.Tickable;
import com.dnamaster10.Util;
import com.dnamaster10.Window;

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
        this.speed = Util.getOrbitalVelocity(rootBody.getMass(), radius);
    }

    @Override
    public void tick() {
        orbitalAngle += (speed / Window.getWindow().core.GetFrameTime());
        while (orbitalAngle > 360) {
            orbitalAngle = orbitalAngle - 360;
        }
        satelliteBody.setX(centerBody.getX() + (float) (Math.cos(orbitalAngle) * radius));
        satelliteBody.setY(centerBody.getY() + (float) (Math.sin(orbitalAngle) * radius));
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
