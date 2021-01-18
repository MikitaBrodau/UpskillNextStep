package com.brodau;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ConfigReader {
    private static final Logger logger = LogManager.getLogger(ConfigReader.class.getName());

    private final Type configEntryType = new TypeToken<ArrayList<ConfigEntry>>() {}.getType();
    private List<ConfigEntry> configEntries;

    public JsonReader readConfig(File config) throws IOException {
        return new JsonReader(new BufferedReader(new FileReader(config)));
    }


    public boolean isFilesExist(JsonReader jsonReader) {
        configEntries = new Gson().fromJson(jsonReader, configEntryType);
        for (ConfigEntry j : configEntries) {
            if (!isConfigEntryFilesExists(j)) {
                return false;
            }
        }
        return true;
    }

    private boolean isConfigEntryFilesExists(ConfigEntry cfgEntry) {
        for (String path : cfgEntry.getFiles()) {
            File file = new File(path);
            if (!file.exists()) {
                logger.fatal("File not exist: " + file.toString());
                return false;
            }
            logger.info("File exist: " + file.toString());
        }
        return true;
    }



    private boolean renameFilesFromConfig(ConfigEntry cfgEntry) {
        for (String path : cfgEntry.getFiles()) {
            File oldFile = new File(path);
            if (!oldFile.renameTo(new File(oldFile.getParent() + "\\" + cfgEntry.getSuffix() + "_" + oldFile.getName()))) {
                return false;
            }
            logger.info("File renamed: " + oldFile.getParent() + "\\" + cfgEntry.getSuffix() + "_" + oldFile.getName());
        }
        return true;
    }

    public Boolean renameAllConfigEntries() {
        for (ConfigEntry cfgEntry : configEntries) {
            if (!renameFilesFromConfig(cfgEntry)) {
                return false;
            }
        }
        return true;
    }
}
