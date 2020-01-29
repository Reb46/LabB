import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.EventListener;

//lobby class
public class StartNewGame extends JFrame {
    private final static String newLine = "\n";
    private static Boolean checker = false;

    StartNewGame(){

        JFrame frame = this;
        setTitle("Waiting for players");

        Button leave = new Button("Abandon the Lobby");

        //center area players entering lobby
        JTextArea textArea = new JTextArea(3, 20);
        String[] playerEntered = new String[3];
        JScrollPane scrollPane = new JScrollPane(textArea); //add new player entering the game
        textArea.setEditable(false);

        playerEntered[0] = "alberto";
        playerEntered[1]= "carlo";
        playerEntered[2]= "pino";

        for (String s : playerEntered) textArea.append(s + newLine);

        //if (player leave) erase that line and re-do the append (player ancora nella partita)
        //erase player from playerEntered array


        //if (players == 3) new GameUI();  ---- richiesta al db


        getContentPane().add(leave, BorderLayout.SOUTH);

        leave.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to abandon the lobby?", "Close lobby",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){

                    //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.)); //send alert to db
                    new LoggedInUI();
                    frame.setVisible(false);
                    frame.dispose();
                }

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });





        getContentPane().add(scrollPane, BorderLayout.CENTER);

        //jframe operative stuff
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}