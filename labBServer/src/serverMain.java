import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class serverMain {

    public static void main(String[] args){
        try {
            ImplementazioneRemota ogg = new ImplementazioneRemota();
            InterfacciaRemotaRdF stub = (InterfacciaRemotaRdF) UnicastRemoteObject.exportObject(ogg, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Nome", stub);
            System.err.println("server pronto!");
        }
        catch (Exception e) {
            System.err.println("Riscontrata eccezione: " + e.toString());
            e.printStackTrace();
        }
    }
}
