package main.devices;

import main.settings.Resolution;

import java.io.File;

public interface Copying extends Device{
    File copy(Resolution resolution, File saveOutput);
}
