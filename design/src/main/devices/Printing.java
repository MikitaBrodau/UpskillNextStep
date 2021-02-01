package main.devices;

import main.settings.Document;
import main.settings.PaperFormat;
import main.settings.Resolution;

public interface Printing {
    void print(int pages, Resolution resolution, PaperFormat paperFormat, Document document);
}
