package Managers;

import java.awt.*;
import javax.swing.*;
import java.util.Map;

import Display.Board;
import Ressources.Ressources;

public class DisplayManager extends JFrame {
    Board grille = new Board(10, 5);

    public DisplayManager() {
        setTitle("Age of Empire ( version nulle )");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1200, 1000);
        add(ressources(), BorderLayout.NORTH);
        add(grid(), BorderLayout.CENTER);

        // Rendre la fenêtre visible
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel ressources() {
        JPanel resourcesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0)); // Utilisation d'un FlowLayout
                                                                                   // horizontal
        for (Map.Entry<String, Ressources> entry : RessourcesManager.getInstance().MapRessource().entrySet()) {
            resourcesPanel.add(createRessourcePanel(entry.getKey(), entry.getValue().getQuantity()));
        }
        return resourcesPanel;
    }

    private JPanel createRessourcePanel(String resourceName, int resourceQuantity) {
        JPanel resourcePanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Utilisation d'un FlowLayout

        // Créer un JLabel pour le nom de la ressource avec une police de caractères
        // plus grande et en gras
        JLabel nameLabel = new JLabel(resourceName);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14)); // Personnaliser la police
        resourcePanel.add(nameLabel);

        // Ajouter un espace entre le nom de la ressource et la quantité
        resourcePanel.add(Box.createRigidArea(new Dimension(5, 0)));

        // Créer un JLabel pour la quantité de la ressource avec une police de
        // caractères italique
        JLabel quantityLabel = new JLabel(": " + resourceQuantity);
        quantityLabel.setFont(new Font("SansSerif", Font.ITALIC, 12)); // Personnaliser la police
        resourcePanel.add(quantityLabel);

        // Ajouter une marge intérieure pour un aspect visuel amélioré
        resourcePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        return resourcePanel;
    }

    private JPanel grid() {
        JPanel gridPanel = new JPanel(new GridLayout(5, 10));
        for (int i = 0; i < grille.Ysize(); i++) {
            for (int j = 0; j < grille.Xsize(); j++) {
                gridPanel.add(grille.getCase(i, j));
            }
        }

        return gridPanel;
    }

}
