package Buildings;

import Managers.RessourcesManager;
import Ressources.RessourcesName;

public class SteelMill extends Building{


    SteelMill()
    {
        this.name = BuildingNames.STEEL_MILL;
        this.population = PopulationBuilder.build(100,60,0);
        this.setBuilt(false);
    }

    @Override
    public void Consumption() {
        System.out.println("SteelMill Consumption");
    }

    @Override
    public void Production() {
        System.out.println("SteelMill Produce");
    }

    public static boolean CONDITION() {
        if (RessourcesManager.getInstance().getResource(RessourcesName.WOOD).getQuantity() >= 100
                && RessourcesManager.getInstance().getResource(RessourcesName.GOLD).getQuantity() >= 6
                && RessourcesManager.getInstance().getResource(RessourcesName.STONE).getQuantity() >= 50) {
            return true;
        } else {
            return false;
        }
    }
}
