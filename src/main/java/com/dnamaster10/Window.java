package com.dnamaster10;

import com.raylib.java.Raylib;

public class Window {
    private static final Raylib raylib = new Raylib(3000, 2000, "Test!");

    public static Raylib getWindow() {
        return raylib;
    }
}
