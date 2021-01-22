package com.brodau;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class XMLMain {
    private static final Logger logger = LogManager.getLogger(XMLMain.class.getName());

    public static void main(String[] args) {
        try {
            logger.trace("Start");

            File config = new File("C:\\Users\\Mikita_Brodau\\upSkillLabNext\\jsonWithLogging\\json.with.logging\\config.xml");
            List<ConfigEntry> configEntryList = getConfigEntries(config);
            EditFilesFromConfigEntry editFilesFromConfigEntry = new EditFilesFromConfigEntry(configEntryList);
            if (EditFilesFromConfigEntry.ifFilesExistRename(editFilesFromConfigEntry)) {
                logger.info("Success");
                getXMLDocWithRenamedFiles(
                        "C:\\Users\\Mikita_Brodau\\upSkillLabNext\\jsonWithLogging\\json.with.logging\\target\\doc.xml",
                        editFilesFromConfigEntry.renamedFilesInfo()
                );
            } else logger.fatal("Files not exist or can't be renamed");

            logger.trace("End of program");
        } catch (JAXBException | IOException e) {
            logger.fatal("Error", e);
        }

    }

    private static List<ConfigEntry> getConfigEntries(File config) throws JAXBException {
        logger.info("Start reading config file");
        JAXBContext jaxbContext = JAXBContext.newInstance(ConfigEntries.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ConfigEntries configEntries = (ConfigEntries) unmarshaller.unmarshal(config);
        logger.info("End reading config file");
        return configEntries.getConfigEntries();
    }

    private static void getXMLDocWithRenamedFiles(String outputPath, List<ConfigEntry> configEntryList) throws JAXBException {
        ConfigEntries configEntries = new ConfigEntries();
        configEntries.setConfigEntries(configEntryList);

        JAXBContext jaxbContext = JAXBContext.newInstance(ConfigEntries.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(configEntries, stringWriter);

        File file = new File(outputPath);
        marshaller.marshal(configEntries, file);
        logger.trace("Created xml output document: " + outputPath);
    }
}
