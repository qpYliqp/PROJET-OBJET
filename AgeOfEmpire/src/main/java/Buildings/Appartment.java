package Buildings;

import Managers.*;
import Ressources.RessourcesName;

public class Appartment extends Building{


    Appartment(){
        this.name = BuildingNames.APPARTMENT;
        this.population = PopulationBuilder.build(100,0,60);
        this.setBuilt(false);
    }

    public static boolean CONDITION()
    {
        if(RessourcesManager.getInstance().getResource(RessourcesName.GOLD).getQuantity() >= 4
        && RessourcesManager.getInstance().getResource(RessourcesName.WOOD).getQuantity() >= 50
        && RessourcesManager.getInstance().getResource(RessourcesName.STONE).getQuantity() >= 50)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void Production()
    {

    }

    @Override
    public void Consumption()
    {

    }
}
