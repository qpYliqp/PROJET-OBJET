package Display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Managers.DisplayManager;

public class Board {
    private Case[][] cases;
    private int x_lenght;
    private int y_lenght;

    public Board(int x_l, int y_l) {
        
        cases = new Case[5][10];
        this.x_lenght = x_l;
        this.y_lenght = y_l;

        for (int i = 0; i < y_lenght; i++) {
            for (int j = 0; j < x_lenght; j++) {
                cases[i][j] = new Case(i, j);
                //cases[i][j].addActionListener(new BoutonCliqueListener(i, j));
            }
        }
    }

    public int Xsize() {
        return this.x_lenght;
    }

    public int Ysize() {
        return this.y_lenght;
    }

    public Case getCase(int x, int y) {
        return cases[x][y];
    }

    
}