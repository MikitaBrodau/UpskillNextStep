package com.brodau;


public class ConfigEntry {
    private final String suffix;
    private final String[] files;

    public ConfigEntry(String suffix, String[] files) {
        this.suffix = suffix;
        this.files = files;
    }

    public String getSuffix() {
        return suffix;
    }

    public String[] getFiles() {
        return files;
    }
}
