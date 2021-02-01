package main;

import main.devices.Copying;
import main.devices.Device;
import main.devices.Printing;

public class Cabinet {
    Device device;

    public Cabinet(Device device) {
        this.device = device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    Copying getCopy(){
        if (device instanceof Copying){
            return (Copying)device;
        }
        else throw new UnsupportedOperationException("Device can't copy");
    }

    Printing getPrint(){
        if (device instanceof Printing){
            return (Printing) device;
        }
        else throw new UnsupportedOperationException("Device can't print");
    }
}
