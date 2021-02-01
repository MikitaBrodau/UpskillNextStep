package main;

import java.util.List;

public class UniversityFloor {
    List<Cabinet> cabinetList;

    public UniversityFloor() {
    }

    public UniversityFloor(List<Cabinet> cabinetList) {
        this.cabinetList = cabinetList;
    }

    public List<Cabinet> getCabinetList() {
        return cabinetList;
    }

    public void setCabinetList(List<Cabinet> cabinetList) {
        this.cabinetList = cabinetList;
    }
}
