package org.frags;

import javax.swing.*;

public class Game {


    public static void main(String[] args) {

        createWindow();

    }


    private static void createWindow() {
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GamePanel panel = new GamePanel();
        frame.add(panel);

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
