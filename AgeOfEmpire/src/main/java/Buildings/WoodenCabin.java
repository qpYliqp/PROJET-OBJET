package Buildings;
import Managers.RessourcesManager;
import Ressources.RessourcesName;

public class WoodenCabin extends Building{

        public WoodenCabin()
        {
            this.name = BuildingNames.WOODEN_CABIN;
            this.population = PopulationBuilder.build(7,2,2);
            this.setConstructionTime(2);
            this.setBuilt(false);
        }

        @Override
        public void Production()
        {
            RessourcesManager.getInstance().getResource(RessourcesName.WOOD).addQuantity(2);
            RessourcesManager.getInstance().getResource(RessourcesName.FOOD).addQuantity(2);
        }

        @Override
        public void Consumption()
        {

        }

        public boolean CONDITION()
        {
            if(RessourcesManager.getInstance().getResource(RessourcesName.WOOD).getQuantity() >= 1
            && RessourcesManager.getInstance().getResource(RessourcesName.GOLD).getQuantity() >= 1)
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
            return "(1 bois, 1 or)";
        }

    @Override
    public void ConstructionRessource()
    {
        RessourcesManager.getInstance().getResource(RessourcesName.WOOD).removeQuantity(1);
        RessourcesManager.getInstance().getResource(RessourcesName.GOLD).removeQuantity(1);
    }
}
