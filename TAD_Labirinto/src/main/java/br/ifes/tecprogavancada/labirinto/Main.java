package br.ifes.tecprogavancada.labirinto;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze("mazes/6x8.csv");

        JFrame frame = new JFrame("Maze Solution");
        MazePanel panel = new MazePanel(maze);
        JScrollPane scrollPane = new JScrollPane(panel);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.pack();

        Insets insets = frame.getInsets();
        frame.setSize(maze.getWidth()*50 + insets.left + insets.right, maze.getHeight()*50 + insets.top + insets.bottom);
        System.out.println(maze.getWidth()*50 + insets.left + insets.right + " " + maze.getHeight()*50 + insets.top + insets.bottom);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}