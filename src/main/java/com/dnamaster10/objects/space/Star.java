package com.dnamaster10.objects.space;

import com.dnamaster10.Drawable;
import com.dnamaster10.Window;
import com.dnamaster10.objects.Positionable;
import com.dnamaster10.objects.SystemObject;
import com.dnamaster10.systems.ShaderManager;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.rlgl.RLGL;

import static com.raylib.java.core.Color.WHITE;
import static com.raylib.java.core.rCore.SetShaderValueV;

public class Star  implements SystemObject, OrbitalBody, Drawable, Positionable {
    static Raylib rl = Window.getWindow();

    //References
    SolarSystem system;

    int age;
    Color color;
    private final float[] colorArray;
    Vector2 drawOrigin;

    Vector2 position = new Vector2();
    float size;
    float mass;

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
        this.size = size;
        this.mass = 0.01f;

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

    @Override
    public float getX() {
        return position.x;
    }

    @Override
    public float getY() {
        return position.y;
    }

    @Override
    public void setX(float x) {
        position.x = x;
    }

    @Override
    public void setY(float y) {
        position.y = y;
    }

    @Override
    public void setPosition(Vector2 position) {
        this.position.x = position.x;
        this.position.y = position.y;
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public void setMass(float mass) {
        this.mass = mass;
    }

    @Override
    public float getMass() {
        return mass;
    }

    @Override
    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public float getSize() {
        return size;
    }
}
