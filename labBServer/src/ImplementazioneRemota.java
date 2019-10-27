import java.rmi.RemoteException;

public class ImplementazioneRemota implements InterfacciaRemotaRdF {

    @Override
    public void mostraMessaggio(String testo) throws RemoteException {
        System.out.println(testo);
    }
}
