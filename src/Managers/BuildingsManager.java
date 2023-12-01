package Managers;

import Buildings.Building;
import Ressources.Ressources;

import java.util.HashMap;
import java.util.Map;

public class BuildingsManager {

    private static BuildingsManager instance;

    private Map<String, Building> resourcesMap;

    public BuildingsManager() {
        this.resourcesMap = new HashMap<>();
    }

    public static synchronized BuildingsManager getInstance() {
        if (instance == null) {
            instance = new BuildingsManager();
        }
        return instance;
    }
}
