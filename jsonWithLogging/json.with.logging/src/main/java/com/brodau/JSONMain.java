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

public class JSONMain {
    private static final Logger logger = LogManager.getLogger(JSONMain.class.getName());

    public static void main(String[] args) {
        try {
            logger.info("Start");
            File config = new File("C:\\Users\\Mikita_Brodau\\upSkillLabNext\\jsonWithLogging\\json.with.logging\\config.json");
            List<ConfigEntry> cfgEntries = jsonConfigEntryType(readConfig(config));
            EditFilesFromConfigEntry configEntry = new EditFilesFromConfigEntry(cfgEntries);
            if (EditFilesFromConfigEntry.ifFilesExistRename(configEntry)) {

                logger.info("Success");
            }
            else logger.fatal("Files not exist or can't be renamed");
            logger.trace("Shutdown program");
        } catch (IOException e) {
            logger.fatal("error", e);
        }
    }


    private static JsonReader readConfig(File config) throws IOException {
        return new JsonReader(new BufferedReader(new FileReader(config)));
    }


    private static List<ConfigEntry> jsonConfigEntryType(JsonReader jsonReader) {
        Type configEntryType = new TypeToken<ArrayList<ConfigEntry>>() {}.getType();
        return new Gson().fromJson(jsonReader, configEntryType);
    }
}