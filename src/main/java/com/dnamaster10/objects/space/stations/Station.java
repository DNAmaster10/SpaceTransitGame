package com.dnamaster10.objects.space.stations;

import com.dnamaster10.Drawable;
import com.dnamaster10.Tickable;
import com.dnamaster10.Window;
import com.dnamaster10.objects.Positionable;
import com.dnamaster10.objects.SystemObject;
import com.dnamaster10.objects.space.OrbitalBody;
import com.dnamaster10.objects.space.SolarSystem;
import com.raylib.java.Raylib;
import com.raylib.java.raymath.Raymath;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.shapes.Rectangle;
import com.raylib.java.textures.Image;
import com.raylib.java.textures.Texture2D;
import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.List;

import static com.raylib.java.core.Color.WHITE;

public class Station implements Tickable, Drawable, SystemObject, Positionable, OrbitalBody {
    private static final Raylib rl = Window.getWindow();

    //References
    SolarSystem system;

    public void setSystem(SolarSystem system) {
        this.system = system;
    }

    //Texture data
    private Texture2D texture;
    private Rectangle sourceRec;
    private Vector2 textureOrigin;
    private Rectangle drawRec;

    public void setTexture(Texture2D texture, Rectangle sourceRec, Vector2 origin, Rectangle drawRec) {
        this.texture = texture;
        this.sourceRec = sourceRec;
        this.drawRec = drawRec;
        this.textureOrigin = origin;
    }

    Vector2 position;

    List<Dock> docks = new ArrayList<>();

    public void addDock(Dock dock) {
        docks.add(dock);
    }

    OrbitalBody centerBody;
    float mass;
    float size;

    public void setCenterBody(OrbitalBody body) {
        this.centerBody = body;
    }

    public Station() {
        position = new Vector2(0f, 0f);
        drawRec = new Rectangle(0f, 0f, 50f, 50f);
    }

    @Override
    public void setPosition(Vector2 position) {
        this.position.x = position.x;
        this.position.y = position.y;
        drawRec.x = position.x - (drawRec.width / 2);
        drawRec.y = position.y - (drawRec.height / 2);
    }

    @Override
    public void setX(float x) {
        position.x = x;
        drawRec.x = position.x - (drawRec.width / 2);
    }

    @Override
    public void setY(float y) {
        position.y = y;
        drawRec.y = position.y - (drawRec.height / 2);
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

    public boolean checkFreeDock() {
        for (Dock dock : docks) {
            if (dock.isAvailable()) return true;
        }
        return false;
    }

    public Dock getAvailableDock() {
        for (Dock dock : docks) {
            if (dock.isAvailable()) return dock;
        }
        return null;
    }

    @Override
    public void tick() {
        //Update positions of docks
        for (Dock dock : docks) dock.tick();
    }

    @Override
    public void draw() {
        rl.textures.DrawTexturePro(texture, sourceRec, drawRec, textureOrigin, 0f, WHITE);
        for (Dock dock : docks) dock.draw();
    }

    @Override
    public SolarSystem getSystem() {
        return this.system;
    }
}