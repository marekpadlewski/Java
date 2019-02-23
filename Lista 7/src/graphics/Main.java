package graphics;

import graphics.Tools;

import javax.swing.*;

public class Main {
    public static Tools tools;
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setSize(800,600);
        window.setLocationRelativeTo(null);
        window.setTitle("Paint");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        tools = new Tools();
        tools.setVisible(true);
        window.add(tools);

        window.setVisible(true);

    }
}