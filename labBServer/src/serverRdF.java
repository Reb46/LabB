import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class serverRdF implements RemoteInterfaceRdF {
    RemoteInterfaceRdF stub;
    Registry registry;

    public static void main(String[] args) {
        serverRdF server = new serverRdF();
    }

    @Override
    public void mostraMessaggio(String testo) throws RemoteException {
        System.out.println(testo);
    }

    private serverRdF(){
        try {
            //System.setProperty("java.rmi.server.hostname","192.168.1.4");
            RemoteInterfaceRdF stub = (RemoteInterfaceRdF) UnicastRemoteObject.exportObject(this, 1099);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Nome", stub);
            System.err.println("server pronto!");
        } catch (Exception e) {
            System.err.println("Riscontrata eccezione: " + e.toString());
            e.printStackTrace();
        }
        /*
        EmailSender test = new EmailSender();
        System.out.println("fine");
         */
    }
}