import java.io.Serializable;

public class PlayerRdF  extends UserRdF implements Serializable {
    private String name;
    private String surname;
    private String password;
    private String emailAddress;
    private String nickName;
    private String userType; //observer/player

    public void playGame(){
    //TODO funziona con l'UI
    }

    public void getDBInfo(){
    //TODO funziona con il DB
    }

    public void observeGame(){
    //TODO funziona con l'UI
    }

    public void addLogMessage(String message) {
        //mostra message nel log
    }
}
