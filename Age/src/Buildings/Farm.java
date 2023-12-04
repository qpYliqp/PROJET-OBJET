package Buildings;

import Managers.RessourcesManager;
import Ressources.RessourcesName;

public class Farm extends Building{


    Farm(){
        this.name = BuildingNames.FARM;
        this.population = PopulationBuilder.build(20,3,5);
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

}
