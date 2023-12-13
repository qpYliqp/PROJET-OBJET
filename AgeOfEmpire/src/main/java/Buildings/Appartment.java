package Buildings;

import Managers.*;
import Ressources.RessourcesName;

public class Appartment extends Building{


    public Appartment(){
        this.name = BuildingNames.APPARTMENT;
        this.population = PopulationBuilder.build(100,0,60);
        this.setConstructionTime(6);
        this.setBuilt(false);
    }

    public boolean CONDITION()
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

    @Override
    public String PrintCondition()
    {
        return "(50 bois, 50 pierre, 4 or)";
    }

    @Override
    public void ConstructionRessource()
    {
        RessourcesManager.getInstance().getResource(RessourcesName.WOOD).removeQuantity(50);
        RessourcesManager.getInstance().getResource(RessourcesName.STONE).removeQuantity(50);
        RessourcesManager.getInstance().getResource(RessourcesName.GOLD).removeQuantity(4);
    }
}
