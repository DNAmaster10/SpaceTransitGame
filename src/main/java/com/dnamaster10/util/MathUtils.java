package com.dnamaster10.util;

import com.dnamaster10.scenes.MainGame;

public class MathUtils {
    public static double getOrbitalVelocity(double orbitalBodyMass, double orbitalRadius) {
        return Math.sqrt(MainGame.GRAVITY_CONSTANT * (orbitalBodyMass / orbitalRadius));
    }
}
