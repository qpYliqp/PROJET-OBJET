import Managers.Manager;
import Ressources.RessourcesName;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Manager manager = new Manager();


        manager.Start();

        manager.ressourcesManager.getResource(RessourcesName.STONE).setQuantity(15);

        System.out.println("STONE : " + manager.ressourcesManager.getResource(RessourcesName.STONE).getQuantity());
    }
    }

