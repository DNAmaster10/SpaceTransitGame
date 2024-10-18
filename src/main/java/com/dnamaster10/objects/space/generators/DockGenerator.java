package com.dnamaster10.objects.space.generators;

import com.dnamaster10.Window;
import com.dnamaster10.objects.space.stations.Dock;
import com.dnamaster10.systems.TextureManager;
import com.dnamaster10.util.YamlReader;
import com.raylib.java.Raylib;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.shapes.Rectangle;
import com.raylib.java.textures.Image;
import com.raylib.java.textures.Texture2D;

import java.io.InputStream;

public class DockGenerator {
    private static final Raylib rl = Window.getWindow();

    public enum DockType {
        SMALL("small_dock.yml");
        public final String filepath;
        DockType(String s) {
            this.filepath = s;
        }
    }

    public static Dock getNewDock(DockType type) {
        Dock dock = new Dock();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream(type.filepath);
        YamlReader yamlReader = new YamlReader(is);

        Texture2D texture = TextureManager.getTexture(yamlReader.getString("texture.file"));

        Rectangle sourceRec = new Rectangle();
        sourceRec.x = yamlReader.getInt("texture.sourceRec.x");
        sourceRec.y = yamlReader.getInt("texture.sourceRec.y");
        sourceRec.width = yamlReader.getInt("texture.sourceRec.width");
        sourceRec.height = yamlReader.getInt("texture.sourceRec.height");

        Rectangle drawRec = new Rectangle();
        drawRec.x = 0;
        drawRec.y = 0;
        drawRec.width = yamlReader.getInt("texture.drawRec.width");
        drawRec.height = yamlReader.getInt("texture.drawRec.height");

        Vector2 origin = new Vector2(sourceRec.x, sourceRec.y);

        dock.setTexture(texture, sourceRec, origin, drawRec);

        return dock;
    }
}
