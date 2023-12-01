package Buildings;

import Managers.RessourcesManager;
import Ressources.RessourcesName;

public class CementPlant extends Building{


    CementPlant(){
        this.name = BuildingNames.CEMENT_PlANT;
        this.population = PopulationBuilder.build(15,10,0);
        this.setBuilt(false);
    }
    @Override
    public void Consumption() {
        System.out.println("CementPlant Consumption");
    }

    @Override
    public void Production() {
        System.out.println("CementPlant Produce");
    }


    public static boolean CONDITION() {
        if (RessourcesManager.getInstance().getResource(RessourcesName.WOOD).getQuantity() >= 50
                && RessourcesManager.getInstance().getResource(RessourcesName.GOLD).getQuantity() >= 6
                && RessourcesManager.getInstance().getResource(RessourcesName.STONE).getQuantity() >= 50) {
            return true;
        } else {
            return false;
        }
    }

}
