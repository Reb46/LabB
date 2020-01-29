import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class LoggedInUI extends JFrame {

    LoggedInUI(){
        JFrame frame = this;
        JPanel jPanelMain = new JPanel(new GridLayout(3,2));

        JButton jButtonStartNewGame = new JButton("Start new Game");
        JButton jButtonSearchNewGame = new JButton("Search Game");

        jButtonSearchNewGame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                //go to new UI
                JOptionPane.showMessageDialog(null, "Redirecting");
                new SearchNewGame();

                frame.setVisible(false);
                frame.dispose();
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
        jButtonStartNewGame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                //go to new UI
                new StartNewGame();

                frame.setVisible(false);
                frame.dispose();


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


        jPanelMain.add(jButtonStartNewGame);
        jPanelMain.add(jButtonSearchNewGame);

        getContentPane().add(jPanelMain, BorderLayout.CENTER);
        //jframe operative stuff
        //setSize(getScreenDim());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
    private Dimension getScreenDim(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }



}