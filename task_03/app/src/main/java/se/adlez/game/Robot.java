package se.adlez.game;

public class Robot extends AbstractMoveableItem {
    private static final long serialVersionUID = 1L;  // Add this field
    
    public Robot(Position position) {   
        super(position);
    }

    @Override
    public String getGraphic() {
        return "🤖";
    }

    @Override
    public String getDescription() {
        return "Robot";
    }
}
