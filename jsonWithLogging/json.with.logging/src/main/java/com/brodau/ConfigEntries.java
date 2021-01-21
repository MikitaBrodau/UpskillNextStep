package com.brodau;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "configEntries")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConfigEntries {

    @XmlElement(name = "configEntry", type = ConfigEntry.class)
    private List<ConfigEntry> configEntries = null;

    public List<ConfigEntry> getConfigEntries() {
        return configEntries;
    }

    public void setConfigEntries(List<ConfigEntry> configEntries) {
        this.configEntries = configEntries;
    }
}
