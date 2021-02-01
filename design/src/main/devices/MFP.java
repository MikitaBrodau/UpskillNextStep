package main.devices;

import main.settings.Document;
import main.settings.PaperFormat;
import main.settings.Resolution;

import java.io.File;

public class MFP implements Copying, Printing{
    @Override
    public File copy(Resolution resolution, File saveOutput) {
        return null;
    }

    @Override
    public void print(int pages, Resolution resolution, PaperFormat paperFormat, Document document) {

    }
}
