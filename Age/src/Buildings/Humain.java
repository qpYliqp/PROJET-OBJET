package Buildings;


import Managers.RessourcesManager;
import Ressources.RessourcesName;

public abstract class Humain {

    String name;

    public String getname()
    {
        return name;
    }

    public void eat()
    {
        RessourcesManager.getInstance().getResource(RessourcesName.FOOD).removeQuantity(1);
    }
}
