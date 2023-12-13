package Buildings;

import Managers.RessourcesManager;
import Ressources.RessourcesName;

public class ToolFactory extends Building{


    public ToolFactory()
    {
        this.name = BuildingNames.TOOL_FACTORY;
        this.population = PopulationBuilder.build(15,12,0);
        this.setConstructionTime(8);
        this.setBuilt(false);
    }
    @Override
    public void Consumption() {

        RessourcesManager.getInstance().getResource(RessourcesName.COAL).removeQuantity(4);
        RessourcesManager.getInstance().getResource(RessourcesName.STEEL).removeQuantity(4);

    }

    @Override
    public void Production()
    {
        RessourcesManager.getInstance().getResource(RessourcesName.TOOLS).addQuantity(4);

    }


    public boolean CONDITION() {
        if (RessourcesManager.getInstance().getResource(RessourcesName.WOOD).getQuantity() >= 50
                && RessourcesManager.getInstance().getResource(RessourcesName.GOLD).getQuantity() >= 8
                && RessourcesManager.getInstance().getResource(RessourcesName.STONE).getQuantity() >= 50) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String PrintCondition()
    {
        return "(50 bois, 50 pierre, 8 or)";
    }

    @Override
    public void ConstructionRessource()
    {
        RessourcesManager.getInstance().getResource(RessourcesName.WOOD).removeQuantity(50);
        RessourcesManager.getInstance().getResource(RessourcesName.STONE).removeQuantity(50);
        RessourcesManager.getInstance().getResource(RessourcesName.GOLD).removeQuantity(8);
    }
}
