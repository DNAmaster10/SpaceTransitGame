package com.dnamaster10.objects.space.generators;

import com.dnamaster10.Window;
import com.dnamaster10.objects.space.stations.Dock;
import com.dnamaster10.objects.space.stations.Station;
import com.dnamaster10.systems.TextureManager;
import com.dnamaster10.util.YamlReader;
import com.raylib.java.Raylib;
import com.raylib.java.raymath.Vector2;
import com.raylib.java.shapes.Rectangle;
import com.raylib.java.textures.Image;
import com.raylib.java.textures.Texture2D;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class StationGenerator {
    private static final Raylib rl = Window.getWindow();

    public enum StationType {
        SMALL("small_station.yml");
        public final String filepath;
        StationType(String s) {
            this.filepath = s;
        }
    }

    public static Station getNewStation(StationType type) {
        Station station = new Station();

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

        station.setTexture(texture, sourceRec, origin, drawRec);

        List<Map<String, Object>> docks = yamlReader.getMapList("docks");
        for (Map<String, Object> dockYaml : docks) {
            YamlReader reader = new YamlReader(dockYaml);
            DockGenerator.DockType dockType = DockGenerator.DockType.valueOf(reader.getString("type"));
            Dock dock = DockGenerator.getNewDock(dockType);
            Vector2 relativePosition = new Vector2();
            relativePosition.x = reader.getInt("relPosition.x");
            relativePosition.y = reader.getInt("relPosition.y");
            dock.setRelativePosition(relativePosition);
            dock.setStation(station);
            station.addDock(dock);
        }
        return station;
    }


}
