package Buildings;

import Managers.RessourcesManager;
import Ressources.RessourcesName;

import java.util.ArrayList;
import java.util.List;

public class Population {

    private int MAX;

    List<Humain> population = new ArrayList<Humain>();

    Population(int max)
    {
        this.MAX = max;
    }

    public int getMAX() {
        return MAX;
    }

    public void add(Humain humain)
    {
        if(population.size() < MAX)
        {
            population.add(humain);
        }
    }

    public int getSize()
    {
        return population.size();
    }

    public void feedPopulation()
    {
        RessourcesManager.getInstance().getResource(RessourcesName.FOOD).removeQuantity(population.size());
    }



}
