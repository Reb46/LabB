import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfacciaRemotaRdF extends Remote {

    //metodi remoti vanno qua

    void mostraMessaggio(String testo) throws RemoteException; //metodo esempio
}
