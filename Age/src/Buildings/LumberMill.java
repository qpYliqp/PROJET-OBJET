package Buildings;

import Managers.RessourcesManager;
import Ressources.RessourcesName;

public class LumberMill extends Building {

    LumberMill(){
        this.name = BuildingNames.LUMBER_MILL;
        this.population = PopulationBuilder.build(15,10,0);
        this.setBuilt(false);
    }

    @Override
    public void Consumption() {

        RessourcesManager.getInstance().getResource(RessourcesName.WOOD).removeQuantity(4);

    }

    @Override
    public void Production()
    {
        RessourcesManager.getInstance().getResource(RessourcesName.LUMBER).addQuantity(4);
    }


    public static boolean CONDITION() {
        if (RessourcesManager.getInstance().getResource(RessourcesName.WOOD).getQuantity() >= 50
        && RessourcesManager.getInstance().getResource(RessourcesName.GOLD).getQuantity() >= 4
        && RessourcesManager.getInstance().getResource(RessourcesName.STONE).getQuantity() >= 50) {
            return true;
        } else {
            return false;
        }
    }

}
