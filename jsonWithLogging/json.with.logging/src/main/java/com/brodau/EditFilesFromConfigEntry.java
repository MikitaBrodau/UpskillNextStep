package com.brodau;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EditFilesFromConfigEntry {
    private static final Logger logger = LogManager.getLogger(EditFilesFromConfigEntry.class.getName());
    private List<ConfigEntry> configEntries;

    public EditFilesFromConfigEntry(List<ConfigEntry> configEntries) {
        this.configEntries = configEntries;
    }

    public boolean isFilesExist() {
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
            logger.trace("File exist: " + file.toString());
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

    private boolean renameFilesFromConfig(ConfigEntry cfgEntry) {
        for (String path : cfgEntry.getFiles()) {
            File oldFile = new File(path);
            if (!oldFile.renameTo(new File(oldFile.getParent() + "\\" + cfgEntry.getSuffix() + "_" + oldFile.getName()))) {
                logger.fatal("Failed to rename file");
                return false;
            }
            logger.info("File renamed: " + oldFile.getParent() + "\\" + cfgEntry.getSuffix() + "_" + oldFile.getName());
        }
        return true;
    }

    public List<ConfigEntry> renamedFilesInfo(){
        for (ConfigEntry cfgEntry : configEntries) {
            String[] paths = cfgEntry.getFiles();
            for (int i = 0; i < paths.length; i++) {
                File file = new File(paths[i]);
                paths[i] = paths[i] + "\t" + ":" + "\t" +
                        (file.getParent() + "\\" + cfgEntry.getSuffix() + "_" + file.getName());
            }
            cfgEntry.setFiles(paths);
        }
        return configEntries;
    }

    public static boolean ifFilesExistRename(EditFilesFromConfigEntry cfgReader) throws IOException {
        if (!cfgReader.isFilesExist()) {
            return false;
        }
        return cfgReader.renameAllConfigEntries();
    }
}
