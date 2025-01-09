package se.adlez.game;

import java.io.Serializable;

public abstract class AbstractItem implements Item, Serializable{
    private static final long serialVersionUID = 1L;
    private final String description;
    private final String graphic;

    public AbstractItem(String description, String graphic) {
        this.description = description;
        this.graphic = graphic;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getGraphic() {
        return graphic;
    }

    @Override
    public String toString() {
        return description + " " + graphic;
    }
}
