package model;

import javax.swing.*;
import java.awt.*;

public class Render extends JPanel {


    public Render() {}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Pi.pi.draw(g);
    }
}
