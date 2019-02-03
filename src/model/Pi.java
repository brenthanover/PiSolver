package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Pi implements ActionListener {

    private int windowWidth  = 410;
    private int windowHeight = 430;
    private int r = 200;
    private int total  = 1;
    private int circle = 0;

    private Render render;
    public static Pi pi;

    public Pi() {
        JFrame jFrame = new JFrame();
        render = new Render();
        Timer timer = new Timer(20, this);


        jFrame.add(render);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(windowWidth, windowHeight);
        jFrame.setVisible(true);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random rand = new Random();

        double x = rand.nextInt(r) + r;
        double y = rand.nextInt(r) + r;
        double d = Math.pow(Math.pow(200 - x, 2) + Math.pow(200-y, 2), .5);
        if (d > r) {
            total++;
        } else if (d < r) {
            circle++;
            total++;
        }

        double pie = 4.0 * circle / total;
        System.out.printf("%.8f", pie);
        System.out.println("");

        render.repaint();
    }


    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawOval(0, 0, r*2, r*2);
        g.drawRect(0,0,r*2,r*2);
    }


    public static void main(String[] args) {
        pi = new Pi();
    }


}
