import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RegisterUI extends JFrame{
    private String[] retrievePassOnClick = new String[3];
    private JPanel topPanel = new JPanel();
    private JPanel midPanel = new JPanel();
    private JPanel botPanel = new JPanel();
    private JPanel botbotPanel = new JPanel();
    private JLabel nickLabel = new JLabel("Nickname: ");
    private JLabel passLabel = new JLabel("Password: ");
    private JLabel mailLabel = new JLabel("Email: ");
    private JCheckBox viewPass = new JCheckBox("Show Password");
    private JButton registerButton = new JButton("Register");
    private JTextField nickTextField = new JTextField();
    private JTextField mailTextField = new JTextField();

    private JPasswordField passwordField = new JPasswordField("");
    private JLabel registerLabelField = new JLabel("Click here to register");

    RegisterUI(){
        super("Register");
        JFrame frame = this;
        topPanel.setLayout(new GridLayout(3, 2));
        topPanel.add(nickLabel);
        topPanel.add(nickTextField);
        topPanel.add(passLabel);
        topPanel.add(passwordField);
        topPanel.add(mailLabel);
        topPanel.add(mailTextField);
        midPanel.setLayout(new FlowLayout());
        midPanel.add(viewPass);
        midPanel.add(registerButton);

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(midPanel, BorderLayout.CENTER);
        int defaultt = passwordField.getEchoChar();
        viewPass.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });

        registerButton.addActionListener(new ActionListener() { //al click di jbutton login
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] getPass = passwordField.getPassword();
                retrievePassOnClick[0] = String.valueOf(getPass);  // ottiene la password
                retrievePassOnClick[1] = nickTextField.getText();  // trasforma il nickname textfield in String
                retrievePassOnClick[2] = mailTextField.getText();  //trasforma il mail textfield in string

                String password = retrievePassOnClick[0];
                String nickname = retrievePassOnClick[1];
                String mail = retrievePassOnClick[2];

                //----manca il retrieve della mail

                if (!password.isEmpty() && !nickname.isEmpty() && !mail.isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "Retrieved");
                    System.out.println(retrievePassOnClick[0] + retrievePassOnClick[1]);
                    //send mail with datas to activate the account?
                    new LoggedInUI();

                    setVisible(false);
                    dispose();

                } else {
                    if (JOptionPane.showConfirmDialog(rootPane,
                            "Back to log in?", "Something went wrong",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        new LoginUI();
                        dispose();
                    } else{
                        JOptionPane.showMessageDialog(rootPane, "Insert valid data");
                    }
                }
            }
        });
        System.out.println(retrievePassOnClick[0]);



        //operative stuff
        pack();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)(dimension.getWidth()-this.getWidth())/2,(int)(dimension.getHeight()-this.getHeight())/2);


        setVisible(true);
    }
}