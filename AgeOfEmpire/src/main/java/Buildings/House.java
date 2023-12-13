package Buildings;

import Managers.RessourcesManager;
import Ressources.RessourcesName;

public class House extends Building{
    public House()
    {
        this.name = BuildingNames.HOUSE;
        this.population = PopulationBuilder.build(7,2,2);
        this.setConstructionTime(4);
        this.setBuilt(false);
    }


    public void Production()
    {

    }

    public boolean CONDITION()
    {
        if(RessourcesManager.getInstance().getResource(RessourcesName.WOOD).getQuantity() >= 2
        && RessourcesManager.getInstance().getResource(RessourcesName.STONE).getQuantity() >= 2
        && RessourcesManager.getInstance().getResource(RessourcesName.GOLD).getQuantity() >= 1)
        {
            return true;
        }
        else
        {
            System.out.println("Vous n'avez pas assez de ressources pour construire une maison");
            return false;
        }
    }

    public void Consumption()
    {

    }

    @Override
    public String PrintCondition()
    {
        return "(2 bois, 2 pierre, 1 or)";
    }

    @Override
    public void ConstructionRessource()
    {
        RessourcesManager.getInstance().getResource(RessourcesName.WOOD).removeQuantity(2);
        RessourcesManager.getInstance().getResource(RessourcesName.STONE).removeQuantity(2);
        RessourcesManager.getInstance().getResource(RessourcesName.GOLD).removeQuantity(1);
    }
}
