package se.adlez.game;

import java.io.Serializable;

public class Position implements Serializable{
    private static final long serialVersionUID = 1L;
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Copy constructor
    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    public int getX() { 
        return x; 
    }
    public int getY() { 
        return y; 
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(Position relative) {
        this.x += relative.getX();
        this.y += relative.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
