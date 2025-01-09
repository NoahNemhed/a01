package se.adlez.game;

import java.io.Serializable;

public class Rock extends AbstractItem implements Serializable{
    private static final long serialVersionUID = 1L;  // Add this field

    public Rock() {
        super("Rock", "🪨 ");
    }
}
