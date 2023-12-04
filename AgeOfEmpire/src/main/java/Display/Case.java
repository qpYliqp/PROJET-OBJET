package Display;

import java.awt.Color;

import javax.swing.JButton;

public class Case extends JButton {

    private boolean occupied;
    private Position pos;

    Case(int x, int y) {
        this.occupied = false;
        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(true);
        setBackground(Color.GREEN);
        pos = new Position(x, y);

    }

    public Position getPosition() {
        return this.pos;
    }

}
