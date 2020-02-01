import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterfaceRdF extends Remote {

    //metodi remoti vanno qua

    //void mostraMessaggio(String testo) throws RemoteException; //metodo esempio

    void addListener(MoveListener test) throws RemoteException;
}
