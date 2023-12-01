package Buildings;

import Managers.RessourcesManager;
import Ressources.RessourcesName;

public class House extends Building{
    public House()
    {
        this.name = BuildingNames.HOUSE;
        this.population = PopulationBuilder.build(7,2,2);
        this.setBuilt(false);
    }


    public void Production()
    {

    }

    public static boolean CONDITION()
    {
        if(RessourcesManager.getInstance().getResource(RessourcesName.WOOD).getQuantity() >= 2
        && RessourcesManager.getInstance().getResource(RessourcesName.STONE).getQuantity() >= 2
        && RessourcesManager.getInstance().getResource(RessourcesName.GOLD).getQuantity() >= 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void Consumption()
    {

    }
}
