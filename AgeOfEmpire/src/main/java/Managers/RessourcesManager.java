package Managers;

import java.util.HashMap;
import java.util.Map;

import Ressources.*;

public class RessourcesManager {
    private static RessourcesManager instance;

    private Map<String, Ressources> resourcesMap;

    public RessourcesManager() {
        this.resourcesMap = new HashMap<>();
        initResources();
    }

    public static synchronized RessourcesManager getInstance() {
        if (instance == null) {
            instance = new RessourcesManager();
        }
        return instance;
    }

    private void initResources() {
        resourcesMap.put(RessourcesName.STONE, new Stone());
        resourcesMap.put(RessourcesName.TOOLS, new Tools());
        resourcesMap.put(RessourcesName.WOOD, new Wood());
        resourcesMap.put(RessourcesName.LUMBER, new Lumber());
        resourcesMap.put(RessourcesName.FOOD, new Food());
        resourcesMap.put(RessourcesName.CEMENT, new Cement());
        resourcesMap.put(RessourcesName.GOLD, new Gold());
        resourcesMap.put(RessourcesName.IRON, new Iron());
        resourcesMap.put(RessourcesName.COAL, new Coal());
        resourcesMap.put(RessourcesName.STEEL, new Steel());
    }

    public Ressources getResource(String resourceName) {
        return resourcesMap.get(resourceName);
    }

    public int lenResource() {
        return resourcesMap.size();
    }

    public Map<String, Ressources> MapRessource() {
        return this.resourcesMap;
    }

}
