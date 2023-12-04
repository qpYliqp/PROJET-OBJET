package Managers;

import Buildings.Building;
import Ressources.Ressources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingsManager {

    private static BuildingsManager instance;

    private List<Building> buildings;

    public BuildingsManager() {
        this.buildings = new ArrayList<>();
    }

    public static synchronized BuildingsManager getInstance() {
        if (instance == null) {
            instance = new BuildingsManager();
        }
        return instance;
    }

    public void addBuilding(Building building) {
        this.buildings.add(building);
    }

    public void removeBuilding(Building building) {
        this.buildings.remove(building);
    }

    public List<Building> getBuildings() {
        return this.buildings;
    }

    public int getBuildingsNumber() {
        return this.buildings.size();
    }

}
