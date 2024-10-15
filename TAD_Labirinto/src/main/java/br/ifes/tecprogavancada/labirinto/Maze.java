package br.ifes.tecprogavancada.labirinto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.awt.*;

public class Maze {
    ArrayList<ArrayList<Integer>> maze;

    private Set<Node> walkedNodes;

    private Stack<Node> stack;

    public Maze(String csvFilename) {
        this.maze = loadMaze(csvFilename);
        this.walkedNodes = null;
        this.stack = null;
    }

    public Maze(ArrayList<ArrayList<Integer>> maze) {
        this.maze = maze;
        this.walkedNodes = null;
        this.stack = null;
    }


    public void runner() throws IllegalArgumentException {
        ArrayList<ArrayList<Integer>> maze = this.copyMaze();
        stack = new Stack<>();
        walkedNodes = new HashSet<>();


        Node head = getStartPoint();
        if (head == null)
            throw new IllegalArgumentException("Erro: Labirinto deve conter uma entrada.");

        stack.add(head);
        walkedNodes.add(head);
        maze.get(head.x).set(head.y, 2);

        do {
            Node nextNode = getNextNode(head, walkedNodes);
            if (nextNode == null) {
                Node last = stack.pop();
                if (stack.isEmpty())
                    break;
                head = stack.peek();
                maze.get(last.x).set(last.y, 1);
            } else {
                head = nextNode;
                stack.add(head);
                walkedNodes.add(head);
                maze.get(head.x).set(head.y, 2);
            }
        } while (!isBorder(head));

    }

    private Node getStartPoint() {
        for (int j = 0; j < this.maze.getFirst().size(); j++)
            if (this.maze.getFirst().get(j) == 1)
                return new Node(0, j);
        for (int i = 1; i < this.maze.size()-1; i++)
            if (this.maze.get(i).getLast() == 1)
                return new Node(i, this.maze.getLast().size()-1);
        for (int j = this.maze.getLast().size()-2; j >= 0; j--)
            if (this.maze.getLast().get(j) == 1)
                return new Node(this.maze.size()-1, j);
        for (int i = this.maze.size()-2; i > 0; i--)
            if (this.maze.get(i).getFirst() == 1)
                return new Node(i, 0);
        return null;
    }

    private Node getNextNode(Node node, Set<Node> walkedNodes) {
        int x = node.x;
        int y = node.y;

        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1}, {0, 1},
                {1, 1}, {1, 0}, {1, -1}, {0, -1}
        };

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX >= 0 && newX < maze.size() && newY >= 0 && newY < maze.getFirst().size()
                    && maze.get(newX).get(newY) == 1 && !walkedNodes.contains(new Node(newX, newY)))
                return new Node(newX, newY);
        }
        return null;
    }

    private boolean isBorder(Node node) {
        int x = node.x;
        int y = node.y;

        return x == 0 || x == this.maze.size() - 1 || y == 0 || y == this.maze.getFirst().size() - 1;
    }

    private ArrayList<ArrayList<Integer>> copyMaze() {
        ArrayList<ArrayList<Integer>> maze = new ArrayList<>();
        for (ArrayList<Integer> row : this.maze)
            maze.add(new ArrayList<>(row));
        return maze;
    }

    public static ArrayList<ArrayList<Integer>> loadMaze(String csvFilename) {
        ArrayList<ArrayList<Integer>> maze = new ArrayList<>();
        File f = new File(csvFilename);

        try (Scanner s = new Scanner(f)) {
            while (s.hasNextLine()) {
                String line = s.nextLine();

                ArrayList<Integer> row = new ArrayList<>();
                for (String v: line.split(","))
                    row.add(Integer.parseInt(v));
                maze.add(row);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado.");
            return null;
        }
        return maze;
    }

    public int getWidth() {
        return this.maze.getFirst().size();
    }

    public int getHeight() {
        return this.maze.size();
    }

    public Set<Node> getWalkedNodes() {
        return walkedNodes;
    }

    public Stack<Node> getSolution() {
        return stack;
    }

}