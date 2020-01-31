import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class clientRdF {

    public static void main(String[] args){
        try {
            System.setProperty("java.rmi.server.hostname","192.168.1.4");
            Registry registry = LocateRegistry.getRegistry("192.168.1.4");
            RemoteInterfaceRdF stub = (RemoteInterfaceRdF) registry.lookup("Nome");
            //new LoginUI();

            //test
            PlayerRdF testplayer = new PlayerRdF();
            MoveListener test = new MoveListener(testplayer);
            stub.addListener(test); stub.addListener(test); stub.addListener(test);

        } catch (Exception e) {
            System.err.println("Eccezione riscontrata: " + e.toString());
            e.printStackTrace();
        }
    }
}
