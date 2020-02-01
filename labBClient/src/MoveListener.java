import java.io.Serializable;
import java.rmi.RemoteException;

public class MoveListener implements Serializable {
    UserRdF client;

    public void makeAMove(String move, PlayerRdF player) {
        /*switch (move) { //aggiorna il tabellone dei client e invia messaggi nel log
            case "consonant": break; //aggiunge eventuali punti e inserisce le consonanti trovate
            case "vowel": break; //toglie 1000 punti e inserisce le vocali trovate
            case "jolly": break; //aggiunge jolly
            case "usedjolly": break; //solo messaggio "giocatore x ha usato il jolly"
            case "loss": break; //fa in modo che il giocatore non possa più giocare
            case "pass": break; //fa passare il turno
        }*/

        //test
        System.out.println(move);
    }

    private void sendLogMessage(String message) {
        client.addLogMessage(message);

    }

    public MoveListener(UserRdF client) throws RemoteException {
        this.client = client;
    }
}
