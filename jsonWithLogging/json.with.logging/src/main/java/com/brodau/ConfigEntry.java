package com.brodau;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "configEntry")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ConfigEntry {
    private  String suffix;
    private  String[] files;

    public ConfigEntry(String suffix, String[] files) {
        this.suffix = suffix;
        this.files = files;
    }
    public ConfigEntry(){
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setFiles(String[] files) {
        this.files = files;
    }

    public String getSuffix() {
        return suffix;
    }

    public String[] getFiles() {
        return files;
    }
}
