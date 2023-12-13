package Managers;

import Buildings.Building;
import Buildings.BuildingNames;
import Ressources.Ressources;
import Ressources.RessourcesName;

import java.util.Map;
import java.util.Scanner;

public class Manager {


    public RessourcesManager ressourcesManager;
    public BuildingsManager buildingsManager;
    private ControleManager controleManager;
    public Manager()
    {
        ressourcesManager = RessourcesManager.getInstance();
        buildingsManager = BuildingsManager.getInstance();
        controleManager = new ControleManager();
    }

    public void Start()
    {
        ressourcesManager.getResource(RessourcesName.STONE).setQuantity(15);
        ressourcesManager.getResource(RessourcesName.WOOD).setQuantity(15);
        ressourcesManager.getResource(RessourcesName.FOOD).setQuantity(100);
        ressourcesManager.getResource(RessourcesName.GOLD).setQuantity(10);
        Run();
    }

    private void Run()
    {
        int index = 0;
        while(controleManager.isRunning())
        {
            if(controleManager.getMenu() == 0)
            {
                System.out.println("\n*******************************************************\n");
                System.out.println("Voici vos ressources : ");
                AfficherRessource();
                System.out.println("\n__________________\n");

                System.out.println("Voici vos batiments : ");
                AfficherBatimentsConstruits();

                System.out.println("\n__________________\n");
                System.out.println("Voici vos bâtiments en construction : ");
                AfficherBatimentsEnConstruction();
                System.out.println("\n__________________\n");
                System.out.println("Que souhaitez-vous faire ?\n");
                System.out.println("1 - Construire un batiment");
                Scanner scanner = new Scanner(System.in);
                int choix = scanner.nextInt();
                controleManager.MenuChoice(choix);
            }
            else if(controleManager.getMenu() == 1)
            {
                System.out.println("\n*******************************************************\n");
                AfficherBatimentAConstruire();
                System.out.println("Ecrire -1 pour faire retour");
                Scanner scanner = new Scanner(System.in);
                int choix = scanner.nextInt();
                controleManager.MenuChoice(choix);
            }
            else if(controleManager.getMenu() == 3)
            {
                System.out.println("\n*******************************************************\n");
                System.out.println("Dans quel batiment souhaitez vous \n");
            }


            //Stop();
        }
    }

    private void AfficherRessource()
    {
        String affichage ="";
        affichage += "\n----------------------------------\n";
        for (Map.Entry<String, Ressources> entry : ressourcesManager.MapRessource().entrySet()) {
            affichage += " * "+entry.getKey() + " : " + entry.getValue().getQuantity();
            affichage += "\n----------------------------------\n";
        }
        System.out.println(affichage);
    }
    private void AfficherBatimentsConstruits()
    {
        int cpt = 0;
        for (String type : buildingsManager.getListType()) {
            int nb = 0;
            for (Building building : buildingsManager.getBuildings()) {
                if (building.getname() == type && building.getBuilt() == true)  {
                    nb++;
                    cpt++;
                }
            }
            if(nb > 0)
            {
                System.out.println(" * " + type + " : " + nb);
            }

        }
        if(cpt == 0)
        {
            System.out.println("Vous n'avez pas encore de batiments construits");
        }
    }

    private void AfficherBatimentsEnConstruction()
    {
        int cpt = 0;
        for (String type : buildingsManager.getListType()) {
            for (Building building : buildingsManager.getBuildings()) {
                if (building.getname() == type && building.getBuilt() == false)  {
                    System.out.println(" * " + type + " : " + building.getConstructionTime() + " tour avant construction : " );
                    cpt++;
                }
            }


            //System.out.println(" * " + type + " : " + nb);
        }
        if(cpt == 0)
        {
            System.out.println("Vous n'avez pas de batiments en construction");
        }
    }

    public void AfficherBatimentsParType(String type) {
        for (String t : buildingsManager.getListType()) {
            int nb = 0;
            for (Building building : buildingsManager.getBuildings()) {
                if (building.getname() == t) {
                    nb++;
                }
            }
            if(nb > 0)
            {
                System.out.println(" * " + t + " : " + nb);
            }
            //System.out.println(" * " + type + " : " + nb);
        }
    }

    private void AfficherBatimentAConstruire(){
        for(int i =0; i < controleManager.getOrder().size();i++)
        {
            Building building = controleManager.getOrder().get(i);
            System.out.println( i + "  " + building.getname() + building.PrintCondition());
        }
    }
    public void Stop()
    {
        controleManager.setRunning(false);
    }
}
