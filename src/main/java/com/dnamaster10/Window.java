package com.dnamaster10;

import com.raylib.java.Raylib;

public class Window {
    private static final Raylib raylib = new Raylib(1000, 1000, "Test!");

    public static Raylib getWindow() {
        return raylib;
    }
}
