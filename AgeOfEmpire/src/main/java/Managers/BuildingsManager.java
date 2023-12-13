package Managers;

import Buildings.Building;
import Buildings.BuildingNames;

import java.util.ArrayList;
import java.util.List;

public class BuildingsManager {

    private static BuildingsManager instance;

    private List<Building> buildings;
    private List<String> types;

    public BuildingsManager() {
        this.buildings = new ArrayList<Building>();
        this.types = new ArrayList<String>();
        InitTypes();
    }

    public static synchronized BuildingsManager getInstance() {
        if (instance == null) {
            instance = new BuildingsManager();
        }
        return instance;
    }

    private void InitTypes() {
        this.types.add(BuildingNames.APPARTMENT);
        this.types.add(BuildingNames.HOUSE);
        this.types.add(BuildingNames.FARM);
        this.types.add(BuildingNames.CEMENT_PlANT);
        this.types.add(BuildingNames.TOOL_FACTORY);
        this.types.add(BuildingNames.LUMBER_MILL);
        this.types.add(BuildingNames.STEEL_MILL);
        this.types.add(BuildingNames.QUARRY);
        this.types.add(BuildingNames.WOODEN_CABIN);
    }

    public List<String> getListType() {
        return this.types;
    }

    public int NombreDeBuildingPourUnType(String type) {
        int nb = 0;
        for (Building building : buildings) {
            if (building.getname() == type) {
                nb++;
            }
        }
        return nb;

    }

    public List<Building> getBuildingsByType(String type) {
        List<Building> buildings = new ArrayList<Building>();
        for (Building building : this.buildings) {
            if (building.getname() == type) {
                buildings.add(building);
            }
        }
        return buildings;
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

    public void Production()
    {
        for(int i = 0; i < buildings.size(); i++)
        {
            if(buildings.get(i).getBuilt() == true)
            {
                buildings.get(i).Production();
            }

        }
    }

    public void Consumption()
    {
        for(int i = 0; i < buildings.size(); i++)
        {
            if(buildings.get(i).getBuilt() == true)
            {
                buildings.get(i).Consumption();
            }
        }
    }

    public void FeedPopulation()
    {
        for(int i = 0; i < buildings.size(); i++)
        {
            if(buildings.get(i).getBuilt() == true)
            {
                buildings.get(i).getPopulation().feedPopulation();
            }
        }
    }

    public void Construction()
    {
        for(int i = 0; i < buildings.size(); i++)
        {
            if(buildings.get(i).getBuilt() == false)
            {
                buildings.get(i).removeConstructionTime(1);
                if(buildings.get(i).getConstructionTime() <= 0)
                {
                    buildings.get(i).setBuilt(true);
                }
            }
        }
    }




}
