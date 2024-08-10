package com.dnamaster10.objects.space;

import com.dnamaster10.Window;
import com.dnamaster10.objects.SystemObject;
import com.dnamaster10.systems.ShaderManager;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.rlgl.RLGL;

import static com.raylib.java.core.Color.WHITE;
import static com.raylib.java.core.rCore.SetShaderValueV;

public class Star extends OrbitalBody implements SystemObject {
    static Raylib rl = Window.getWindow();

    //References
    SolarSystem system;

    int age;
    Color color;
    private final float[] colorArray;
    Vector2 drawOrigin;

    public Star(float mass, int age, SolarSystem system) {
        float size = 0;
        this.age = age;

        if (mass < 900 && mass > 300) {
            size = mass / 10;
        } else if (mass <= 300) {
            size = 300f / 10;
        }

        int colourChangeAmount = (int) (765f / ( 1000f / age));
        if (colourChangeAmount <= 255) {
            this.color = new Color(colourChangeAmount, colourChangeAmount, 255, 255);
        } else if (colourChangeAmount <= 510) {
            int yellowAmount = colourChangeAmount - 255;
            this.color = new Color(255, 255, 255 - yellowAmount, 255);
        } else {
            int redAmount = colourChangeAmount - 510;
            this.color = new Color(255, 255 - redAmount, 0, 255);
        }

        if (mass > 900) {
            //this.color = new Color(0, 0, 0, 255);
        }

        colorArray = new float[]{color.getR() / 255f, color.getG() / 255f, color.getB() / 255f};

        drawOrigin = new Vector2(getX() - size, getY() - size);
        super.setSize(size);
        super.setMass(0.01f);

        this.system = system;
    }

    @Override
    public void draw() {
        SetShaderValueV(ShaderManager.STAR_SHADER, ShaderManager.STAR_COLOUR_LOC, colorArray, RLGL.rlShaderUniformDataType.RL_SHADER_UNIFORM_VEC3, 3);
        rl.textures.DrawTextureEx(ShaderManager.BLANK_TEXTURE, drawOrigin, 0f, (getSize() * 2) + 20f, WHITE);
    }

    @Override
    public SolarSystem getSystem() {
        return this.system;
    }
}
