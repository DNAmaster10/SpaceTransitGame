package com.dnamaster10.util;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class YamlReader {
    private final Map<String, Object> data;

    public YamlReader(InputStream inputStream) {
        Yaml yaml = new Yaml();
        this.data = yaml.load(inputStream);
    }

    public YamlReader(Map<String, Object> data) {
        this.data = data;
    }

    public String getString(String key) {
        return (String) getValueByKeyPath(key);
    }

    public int getInt(String key) {
        return (int) getValueByKeyPath(key);
    }

    @SuppressWarnings("unchecked")
    public List<String> getStringList(String key) {
        Object value = getValueByKeyPath(key);
        return value instanceof List ? (List<String>) value : null;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getMapList(String key) {
        Object value = getValueByKeyPath(key);
        return value instanceof List ? (List<Map<String, Object>>) value : null;
    }

    @SuppressWarnings("unchecked")
    private Object getValueByKeyPath(String keyPath) {
        String[] keys = keyPath.split("\\.");
        Map<String, Object> currentMap = data;
        Object value = null;

        for (String key : keys) {
            value = currentMap.get(key);

            if (value instanceof Map) {
                currentMap = (Map<String, Object>) value;
            } else break;
        }
        return value;
    }
}
