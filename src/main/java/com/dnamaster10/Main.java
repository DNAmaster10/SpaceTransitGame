package com.dnamaster10;

import com.dnamaster10.scenes.MainGame;
import com.raylib.java.Raylib;

import java.io.IOException;

import static com.raylib.java.Config.ConfigFlag.*;
import static com.raylib.java.core.Color.BLACK;

public class Main {
    public static void main(String[] args) throws IOException {

        Raylib rl = Window.getWindow();
        rl.core.SetTargetFPS(60);
        rl.core.SetWindowMinSize(100, 100);
        rl.core.SetConfigFlags(FLAG_WINDOW_RESIZABLE);
        rl.core.SetConfigFlags(FLAG_WINDOW_UNDECORATED);


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