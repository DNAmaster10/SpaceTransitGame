package com.dnamaster10.objects.space.stations;

import com.dnamaster10.Drawable;
import com.dnamaster10.Tickable;
import com.dnamaster10.Window;
import com.dnamaster10.objects.Positionable;
import com.dnamaster10.objects.StationObject;
import com.dnamaster10.objects.SystemObject;
import com.dnamaster10.objects.space.SolarSystem;
import com.raylib.java.Raylib;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.shapes.Rectangle;
import com.raylib.java.textures.Image;
import com.raylib.java.textures.Texture2D;

import static com.raylib.java.core.Color.WHITE;

public class Dock implements Positionable, SystemObject, StationObject, Drawable, Tickable {
    private static final Raylib rl = Window.getWindow();

    //References
    Station station;

    public void setStation(Station station) {
        this.station = station;
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

    private Vector2 position = new Vector2();
    Vector2 relativePosition = new Vector2();
    boolean reserved = false;
    boolean occupied = false;


    public Vector2 getPosition() {
        return this.position;
    }

    public Vector2 getRelativePosition() {
        return this.relativePosition;
    }

    public void setRelativePosition(Vector2 relativePosition) {
        this.relativePosition.x = relativePosition.x;
        this.relativePosition.y = relativePosition.y;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
        this.drawRec.x = position.x - (drawRec.width / 2);
        this.drawRec.y = position.y - (drawRec.height / 2);
    }

    public boolean isAvailable() {
        return !reserved && !occupied;
    }

    @Override
    public SolarSystem getSystem() {
        return station.getSystem();
    }

    @Override
    public Station getStation() {
        return station;
    }

    @Override
    public void tick() {
        position.x = station.getX() + relativePosition.x;
        position.y = station.getY() + relativePosition.y;
        drawRec.x = position.x - (drawRec.width / 2);
        drawRec.y = position.y - (drawRec.height / 2);
    }

    @Override
    public void draw() {
        rl.textures.DrawTexturePro(texture, sourceRec, drawRec, textureOrigin, 0f, WHITE);
    }
}
