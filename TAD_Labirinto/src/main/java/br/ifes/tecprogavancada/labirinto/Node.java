package br.ifes.tecprogavancada.labirinto;

import java.util.Objects;

public class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return this.x == node.x && this.y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
