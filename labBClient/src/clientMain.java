import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class clientMain {

    public static void main(String[] args){
        try {
            Registry registry = LocateRegistry.getRegistry(null);
            InterfacciaRemotaRdF stub = (InterfacciaRemotaRdF) registry.lookup("Nome");
            stub.mostraMessaggio("Ciao mondo!");
        } catch (Exception e) {
            System.err.println("Eccezione riscontrata: " + e.toString());
            e.printStackTrace();
        }
    }
}
