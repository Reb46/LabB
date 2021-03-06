import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginUI extends JFrame {
    private String[] retrievePassOnClick = new String[2];
    JPanel botPanel = new JPanel();
    JLabel nickLabel = new JLabel("Nickname: ");
    JLabel passLabel = new JLabel("Password: ");
    JCheckBox viewPass = new JCheckBox("Show Password");
    JButton logButton = new JButton("Log In");
    JTextField nickTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField("");
    JLabel registerLabelField = new JLabel("Click here to register");
    JPanel topPanel = new JPanel();
    JPanel midPanel = new JPanel();


    LoginUI () {
        super("Login");
        topPanel.setLayout(new GridLayout(2, 2));
        topPanel.add(nickLabel);
        topPanel.add(nickTextField);
        topPanel.add(passLabel);
        topPanel.add(passwordField);
        midPanel.setLayout(new FlowLayout());
        midPanel.add(logButton);
        midPanel.add(viewPass);
        botPanel.setLayout(new FlowLayout());
        botPanel.add(registerLabelField);
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(midPanel, BorderLayout.CENTER);
        getContentPane().add(botPanel, BorderLayout.SOUTH);
        viewPass.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });

        //login redirect and checks
        //al click di jbutton login
        logButton.addActionListener(e -> {
            char[] getPass = passwordField.getPassword();
            retrievePassOnClick[0] = String.valueOf(getPass);  // ottiene la password
            retrievePassOnClick[1] = nickTextField.getText();  // trasforma il jtextfield in String

            if (retrievePassOnClick[0]!=null && retrievePassOnClick[1]!=null){
                //if password match db...
                JOptionPane.showMessageDialog(rootPane, "Retrieved  " +retrievePassOnClick[0] + "  " + retrievePassOnClick[1]);
                new LoggedInUI();

                //setVisible(false);
                dispose();

                //else JOptionPane.showMessageDialog(rootPane, "Nickname/Password doesn't match");

            } else
                JOptionPane.showMessageDialog(rootPane, "Something went wrong");
        });


        //register class redirect on click
        registerLabelField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new RegisterUI();

                //setVisible(false);
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        //operatives stuff
        pack();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)(dimension.getWidth()-this.getWidth())/2,(int)(dimension.getHeight()-this.getHeight())/2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


    public static void main (String[] arg){
        new LoginUI();
    }
}