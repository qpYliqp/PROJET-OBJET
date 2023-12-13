package Managers;

import Buildings.Appartment;
import Buildings.Building;

import javax.naming.ldap.Control;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import Buildings.*;
import Ressources.RessourcesName;
import Ressources.Ressources;

public class ControleManager {

    private int menu;


    private boolean isRunning = true;


    private List<Building> order;

    ControleManager() {
        this.menu = 0;
        order = new ArrayList<Building>();
        order.add(new Appartment());
        order.add(new House());
        order.add(new Farm());
        order.add(new CementPlant());
        order.add(new ToolFactory());
        order.add(new LumberMill());
        order.add(new SteelMill());
        order.add(new Quarry());
        order.add(new WoodenCabin());

    }

    // Menu représente l'interface à afficher, puis le choix de l'utilisateur
    public void MenuChoice(int choice) {

        if (menu == 0) {
            if (choice == 1) {
                this.menu = 1;
            }
            else if(choice == 2)
            {
                this.menu = 3;
            }
        }
        else if (menu == 1) {
            if (choice == -1) {
                this.menu = 0;
            } else if (choice >= 0 && choice <= order.size()) {
                BuildingCreation(choice);
            }
        }
    }

    public int getMenu() {
        return this.menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    private void BuildingCreation(int choice) {
        Building batiment = null;

        switch (choice)
        {
            default: break;
            case -1:
                this.menu = 0;
                break;
            case 0:
                batiment = new Appartment();
                break;
            case 1:
                batiment = new House();
                break;
            case 2:
                batiment = new Farm();
                break;
            case 3:
                batiment = new CementPlant();
                break;
            case 4:
                batiment = new ToolFactory();
                break;
            case 5:
                batiment = new LumberMill();
                break;
            case 6:
                batiment = new SteelMill();
                break;
            case 7:
                batiment = new Quarry();
                break;
            case 8:
                batiment = new WoodenCabin();
                break;

        }
        if(batiment != null && batiment.CONDITION())
        {
            batiment.ConstructionRessource();
            BuildingsManager.getInstance().addBuilding(batiment);
            Turn();
            this.menu = 0;
        }
        else if(batiment != null)
        {
            System.out.println("Vous n'avez pas assez de ressources pour construire ce batiment");
        }
    }


    //Fonction qui est appelée quand un tour est joué.
    public void Turn() {

        BuildingsManager.getInstance().Production();
        BuildingsManager.getInstance().Consumption();
        BuildingsManager.getInstance().FeedPopulation();
        BuildingsManager.getInstance().Construction();
        Victory();

    }

    private void Victory()
    {
        for(Map.Entry<String, Ressources> entry: RessourcesManager.getInstance().MapRessource().entrySet())
        {
            if(entry.getValue().getQuantity() < 0 && entry.getValue().getName() != RessourcesName.GOLD)
            {
                System.out.println("Vous n'avez plus de "+entry.getValue().getName()+", vous avez perdu");
                this.isRunning = false;
            }
        }
       if(RessourcesManager.getInstance().getResource(RessourcesName.GOLD).getQuantity() >= 1000)
        {
            System.out.println("Vous avez gagné");
            this.isRunning = false;
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public List<Building> getOrder() {
        return order;
    }
}
