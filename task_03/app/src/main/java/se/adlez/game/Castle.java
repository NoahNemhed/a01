package se.adlez.game;

public class Castle extends AbstractMoveableItem{
    private static final long serialVersionUID = 1L; 
    
    public Castle(Position position) {
        super(position);
    }

    @Override
    public String getGraphic() {
        return "🏛️";
    }

    @Override
    public String getDescription() {
        return "Castle";
    }

}
