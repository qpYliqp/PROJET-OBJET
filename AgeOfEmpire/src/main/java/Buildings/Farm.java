package Buildings;

import Managers.RessourcesManager;
import Ressources.RessourcesName;

public class Farm extends Building{


    public Farm(){
        this.name = BuildingNames.FARM;
        this.population = PopulationBuilder.build(20,3,5);
        this.setConstructionTime(2);
        this.setBuilt(false);
    }
    @Override
    public void Production()
    {
        RessourcesManager.getInstance().getResource(RessourcesName.FOOD).addQuantity(10);
    }

    @Override
    public void Consumption()
    {

    }

    @Override
    public boolean CONDITION()
    {
        if(RessourcesManager.getInstance().getResource(RessourcesName.WOOD).getQuantity() >= 5
        && RessourcesManager.getInstance().getResource(RessourcesName.GOLD).getQuantity() >= 4
        && RessourcesManager.getInstance().getResource(RessourcesName.STONE).getQuantity() >= 5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String PrintCondition()
    {
        return "(5 bois, 5 pierre, 4 or)";
    }
    @Override
    public void ConstructionRessource()
    {
        RessourcesManager.getInstance().getResource(RessourcesName.WOOD).removeQuantity(5);
        RessourcesManager.getInstance().getResource(RessourcesName.STONE).removeQuantity(5);
        RessourcesManager.getInstance().getResource(RessourcesName.GOLD).removeQuantity(4);
    }


}
