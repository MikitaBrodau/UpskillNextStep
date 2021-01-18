package com.brodau;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            logger.info("Start");
            ConfigReader cf = new ConfigReader();
            File config = new File("C:\\Users\\Mikita_Brodau\\upSkillLabNext\\jsonWithLogging\\json.with.logging\\config.json");

            if (ifFilesExistRename(cf, config)) {
                logger.info("Success");
            }
            else logger.fatal("Fail to rename");

            logger.trace("Shutdown program");
        } catch (IOException e) {
            logger.fatal("error", e);
        }
    }

    private static boolean ifFilesExistRename(ConfigReader cfgReader, File cfgPath) throws IOException {
        if (!cfgReader.isFilesExist(cfgReader.readConfig(cfgPath))) {
            return false;
        }
        return cfgReader.renameAllConfigEntries();
    }
}