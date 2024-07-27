package com.dnamaster10;

import com.dnamaster10.scenes.MainGame;
import com.raylib.java.Raylib;

import static com.raylib.java.core.Color.BLACK;

public class Main {
    public static void main(String[] args) {

        Raylib rl = Window.getWindow();
        rl.core.SetTargetFPS(60);
        Scene mainGame = new MainGame();

        //Initialize frame time for use with getFrameTime()
        rl.core.BeginDrawing();
        rl.core.ClearBackground(BLACK);
        rl.core.EndDrawing();

        while (!rl.core.WindowShouldClose()) {
            mainGame.tick();
            mainGame.draw();
        }
    }
}