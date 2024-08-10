package com.dnamaster10.systems;

import com.dnamaster10.Window;
import com.raylib.java.rlgl.shader.Shader;
import com.raylib.java.shapes.Rectangle;
import com.raylib.java.textures.Texture2D;

import static com.raylib.java.core.Color.WHITE;
import static com.raylib.java.core.rCore.GetShaderLocation;

public class ShaderManager {
    public static final Rectangle BLANK_TEXTURE_SOURCE_RECT = new Rectangle(0, 0, 1, 1);
    public static final Texture2D BLANK_TEXTURE = Window.getWindow().textures.LoadTextureFromImage(Window.getWindow().textures.GenImageColor(1, 1, WHITE));

    public static final Shader STAR_SHADER = Window.getWindow().core.LoadShader("star.vs", "star.rs");
    public static final int STAR_COLOUR_LOC = GetShaderLocation(STAR_SHADER, "starColor");


}
