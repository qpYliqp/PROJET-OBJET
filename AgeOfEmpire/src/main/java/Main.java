import javax.swing.SwingUtilities;

import Managers.Manager;
//import Display.Board;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Manager manager = new Manager();

        manager.Start();
        //SwingUtilities.invokeLater(() -> new DisplayManager());
    }
}