package com.dnamaster10.systems;

import com.dnamaster10.Window;
import com.raylib.java.Raylib;
import com.raylib.java.textures.Image;
import com.raylib.java.textures.Texture2D;

import java.util.HashMap;

public class TextureManager {
    private static final Raylib rl = Window.getWindow();
    private static final HashMap<String, Texture2D> textures = new HashMap<>();

    public static Texture2D getTexture(String filepath) {
        if (textures.containsKey(filepath)) return textures.get(filepath);

        Image image = rl.textures.LoadImage(filepath);
        Texture2D texture = rl.textures.LoadTextureFromImage(image);

        textures.put(filepath, texture);
        return texture;
    }
}
