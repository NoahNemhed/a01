package se.adlez.game;

import java.io.Serializable;

public abstract class AbstractMoveableItem implements Item, Serializable, Moveable {
    private static final long serialVersionUID = 1L;
    private final Position position;

    public AbstractMoveableItem(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract String getGraphic();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + getGraphic() + " " + position;
    }
}