package com.brodau;

public class DocumentXMLRenamedFilesOutput {
    private final String beforeRename;
    private final String afterRename;

    public DocumentXMLRenamedFilesOutput(String beforeRename, String afterRename) {
        this.beforeRename = beforeRename;
        this.afterRename = afterRename;
    }

    public String getBeforeRename() {
        return beforeRename;
    }

    public String getAfterRename() {
        return afterRename;
    }
}
