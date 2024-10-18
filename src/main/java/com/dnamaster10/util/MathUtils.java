package com.dnamaster10.util;

import com.dnamaster10.scenes.SystemScene;

public class MathUtils {
    public static double getOrbitalVelocity(double orbitalBodyMass, double orbitalRadius) {
        return Math.sqrt(SystemScene.GRAVITY_CONSTANT * (orbitalBodyMass / orbitalRadius));
    }
}
