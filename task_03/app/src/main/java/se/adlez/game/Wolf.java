package se.adlez.game;

public class Wolf extends AbstractMoveableItem {
    private static final long serialVersionUID = 1L;  // Add this field
    
    public Wolf(Position position) {
        super(position);
    }

    @Override
    public String getGraphic() {
        return "🐺";
    }

    @Override
    public String getDescription() {
        return "Wolf";
    }
}
