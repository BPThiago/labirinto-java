package br.ifes.tecprogavancada.labirinto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MazePanel extends JPanel {
    private Maze maze;
    private ArrayList<Node> solution;
    private int currentStep = 0;
    private Timer timer;

    public MazePanel(Maze maze) {
        this.maze = maze;
        this.maze.runner();
        this.solution = new ArrayList<>(maze.getSolution());  // Armazena o caminho na ordem correta

        // Configura o timer para mover o quadrado
        this.timer = new Timer(500, e -> moveNext());  // Atualiza a cada 500ms (meio segundo)
        this.timer.start();
    }

    // Método chamado a cada intervalo de tempo para mover o quadrado
    private void moveNext() {
        if (currentStep < solution.size() - 1) {
            currentStep++;  // Move para o próximo nó
            repaint();  // Atualiza o painel para redesenhar
        } else {
            timer.stop();  // Para o timer quando não há mais movimentos
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.setBackground(Color.black);


        // Desenha o labirinto
        for (int i = 0; i < this.maze.getHeight(); i++) {
            for (int j = 0; j < this.maze.getWidth(); j++) {
                if (this.maze.maze.get(i).get(j) == 1) {
                    g.setColor(Color.white);
                    g.fillRect(j * 50, i * 50, 50, 50);  // Desenha o caminho do labirinto
                }
            }
        }

        for (Node n : maze.getWalkedNodes()){
            g.setColor(Color.lightGray);
            g.fillRect(n.y * 50, n.x * 50, 50, 50);
        }

        // Desenha o caminho percorrido até o momento (de cima para baixo)
        g.setColor(Color.red);
        for (int i = 0; i <= currentStep; i++) {
            Node step = solution.get(i);
            g.fillRect(step.y * 50, step.x * 50, 50, 50);
        }


    }
}
