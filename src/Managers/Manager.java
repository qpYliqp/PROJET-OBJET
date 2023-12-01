package Managers;

import Ressources.RessourcesName;

public class Manager {
    RessourcesManager ressourcesManager;
    public Manager()
    {
        ressourcesManager = RessourcesManager.getInstance();
    }

    public void Start()
    {
        System.out.println("WELCOME TO THE GAME");
        ressourcesManager.getResource(RessourcesName.STONE).setQuantity(10);
        ressourcesManager.getResource(RessourcesName.WOOD).setQuantity(10);
        ressourcesManager.getResource(RessourcesName.FOOD).setQuantity(10);
        ressourcesManager.getResource(RessourcesName.GOLD).setQuantity(10);

        ressourcesManager.printRessources();
    }
}
