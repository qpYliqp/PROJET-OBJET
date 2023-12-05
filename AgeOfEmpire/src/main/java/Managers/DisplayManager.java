package Managers;

import java.awt.*;
import javax.swing.*;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Display.Board;
import Ressources.Ressources;
import Display.Case;

public class DisplayManager extends JFrame {
    Board grille = new Board(10, 5);
    //List<JPanel> windows = new ArrayList<JPanel>();

    private static DisplayManager instance;  // Instance unique de la classe
    private Case current;
    private JPanel test = null;

        public static DisplayManager getInstance() {
        if (instance == null) {
            instance = new DisplayManager();
        }
        return instance;
    }

    private DisplayManager() {


        SwingUtilities.invokeLater(() -> Init());
    }

    private void Init()
    {
        current = null;
        setTitle("Age of Empire ( version nulle )");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(ressources(), BorderLayout.NORTH);
        add(grid(), BorderLayout.CENTER);

        // Rendre la fenêtre visible
        setLocationRelativeTo(null);
        setVisible(true);
        // Maximiser la fenêtre
        setExtendedState(JFrame.MAXIMIZED_BOTH);

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
                grille.getCase(i,j).addActionListener(new CaseClickListener(i,j));
            }
        }

        return gridPanel;
    }

    private class CaseClickListener implements ActionListener {
        private int ligne;
        private int colonne;

        public CaseClickListener(int ligne, int colonne) {
            this.ligne = ligne;
            this.colonne = colonne;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (current != null) 
            {
                //DisplayManager.test();                
                if (ligne == current.getPosition().getX() && colonne == current.getPosition().getY()) {
                    current.setBackground(Color.GREEN);
                    current = null;
                } else {
                    current.setBackground(Color.GREEN);
                    current = grille.getCase(ligne, colonne);
                    current.setBackground(Color.WHITE);
                }
            } else if (current == null) {
                //DisplayManager.remove();
                current = grille.getCase(ligne, colonne);
                current.setBackground(Color.WHITE);
            }

        }
    }

    public void test()
    {
        test = ressources();
        add(test,BorderLayout.SOUTH);
        
    }

    public void remove()
    {
        if(test != null)
        {
            remove(test);
            revalidate();
            repaint();
        }
    }

}
