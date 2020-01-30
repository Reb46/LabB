public class MoveListener {
Game game;
PlayerRdF client;

public void makeAMove(String move){
        switch (move){ //aggiorna il tabellone dei client e invia messaggi nel log
            case "consonant": break; //aggiunge eventuali punti e inserisce le consonanti trovate
            case "vowel": break; //toglie 1000 punti e inserisce le vocali trovate
            case "jolly": break; //aggiunge jolly
            case "usedjolly": break; //solo messaggio "giocatore x ha usato il jolly"
            case "loss": break; //fa in modo che il giocatore non possa più giocare
            case "pass": break; //fa passare il turno
        }
    }

    public MoveListener(Game game, PlayerRdF client){
        this.game = game;
        this.client = client;
    }
}
