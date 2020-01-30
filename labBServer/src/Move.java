public class Move {
    private String move;
    private PlayerRdF player;
    //private int points;

    public Move(Round current, String m) { //costruttore
        player = current.getCurrentPlayer();
        move = m;
        //points = pointsChange; serve?
    }

    //metodi per ottenere info per statistiche?

    public String getMove() {
        return move;
    }
}