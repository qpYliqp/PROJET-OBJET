package Buildings;

import Managers.RessourcesManager;
import Ressources.RessourcesName;

public class Quarry extends Building{

    Quarry(){
        this.name = BuildingNames.QUARRY;
        this.population = PopulationBuilder.build(15,3,5);
        this.setBuilt(false);
    }
    @Override
    public void Production()
    {
        RessourcesManager.getInstance().getResource(RessourcesName.COAL).addQuantity(4);
        RessourcesManager.getInstance().getResource(RessourcesName.IRON).addQuantity(4);
        RessourcesManager.getInstance().getResource(RessourcesName.STONE).addQuantity(4);
        RessourcesManager.getInstance().getResource(RessourcesName.GOLD).addQuantity(2);
    }


    @Override
    public void Consumption()
    {

    }
    public static boolean CONDITION()
    {
        if(RessourcesManager.getInstance().getResource(RessourcesName.WOOD).getQuantity() >= 50
        && RessourcesManager.getInstance().getResource(RessourcesName.GOLD).getQuantity() >= 4)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
