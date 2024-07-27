package com.dnamaster10;

import com.dnamaster10.scenes.MainGame;

public class Util {
    public static double getOrbitalVelocity(double orbitalBodyMass, double orbitalRadius) {
        return Math.sqrt(MainGame.GRAVITY_CONSTANT * (orbitalBodyMass / orbitalRadius));
    }
}
