import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

class GameUI extends JFrame{
    private boolean myTurn = true;
    private boolean [] charsRelatedValues;
    private char [] cSecretWord;
    private int nWords;
    private boolean firstTurn;
    private String resultWheel;
    private String playerActive;
    private int money;
    private int [] moneyA;


    public static void main (String [] arg) throws IOException {

        new GameUI();

    }


    GameUI () throws IOException {

        firstTurn = true; // game.isFirstTurn() //da server
        moneyA = new int[3];
        int playern = whichPlayer();
        money = moneyA[playern-1];

        //buttons
        JButton answerButton = new JButton("Answer");
        JButton passButton = new JButton("Pass");
        JButton vowelButton = new JButton("Vowel");
        JButton wheelButton = new JButton("Spin the Wheel");
        JCheckBox jollyBox = new JCheckBox("Check to use Jolly");

        //secret word
        String secretWord = "il cielo è limpido"; //getter from game
        int wLength = secretWord.length();
        int index = 0;
        cSecretWord = new char[wLength];
        if (firstTurn){
            disableButtons(answerButton, passButton, vowelButton);
            for (int i = 0; i < 3; i++) {
                moneyA[i] = 0;
            }
            if (secretWord != null) {
                StringTokenizer tokenizer = new StringTokenizer(secretWord, " ");
                nWords = tokenizer.countTokens();
                cSecretWord = new char[wLength];
                charsRelatedValues = new boolean[wLength];

                for (int i = 0; i < wLength; i++) {
                    char c = secretWord.charAt(i);
                    cSecretWord[i] = c;

                    if (c == ' ')
                        charsRelatedValues[i] = true;
                    else if (!isVowel(c)) {
                        charsRelatedValues[i] = false;
                    } else
                        charsRelatedValues[i] = false;

                }
            }
        }


        boolean consonantFound = true;
        int count = 0;
        for (int i = 0; i < wLength; i++) {
            //t++;
            consonantFound = false;
        }
        if (count == wLength ) //mettere controllo consonanti
            consonantFound = true;

        if (consonantFound){
            JOptionPane.showMessageDialog(null, "All consonat found!");
        }

        //Wheel image initializer
        BufferedImage image = ImageIO.read(new File("ruotadellafortuna.png"));
        JLabel imageLB = new JLabel(new ImageIcon(image));




        if (!myTurn) {
            disableButtons(answerButton, wheelButton, passButton, vowelButton);
        }
        //-----wrap in if case
        answerButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {


                if (myTurn && !firstTurn){
                    //swing timer 10sec
                    String answer = JOptionPane.showInputDialog("Write the Answer");
                    if (answer.equals(secretWord)){
                        //set winning stuf

                        JOptionPane.showMessageDialog(null, "You WIN!");

                    }
                    else {
                        //inserire check jolly
                        if (jollyBox.isSelected()) {
                            //check se possiede un jolly
                            /* if(possiede jolly){
                                    JOptionPane.showMessageDialog(null, "Wrong Answer, using Jolly");
                                    changeTurn(true);//override a stesso player
                                }
                                else{
                                  //nextplayer
                                    changeTurn();
                                    JOptionPane.showMessageDialog(null, "Next Player");
                                    }
                                */

                        }  else{
                            //nextplayer
                            changeTurn();
                            JOptionPane.showMessageDialog(null, "Next Player");
                        }

                    }
                }
                else if (firstTurn) {
                    JOptionPane.showMessageDialog(null, "You can't give the answer in the first turn");

                } else
                    JOptionPane.showMessageDialog(null, "Wait for your turn");

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

        //wheel button
        wheelButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {


                if (myTurn){
                    //String result = metodo Spintheweel
                    String result = "1000";
                    JOptionPane.showMessageDialog(null, "Result");

                    if (result.equals("PASS")){
                        if(jollyBox.isSelected()) {
                           /* if(possiede jolly){
                                    JOptionPane.showMessageDialog(null, "Wrong Answer, using Jolly");
                                    changeTurn(true);//override a stesso player
                                }
                                else{
                                  //nextplayer
                                    changeTurn();
                                    JOptionPane.showMessageDialog(null, "Next Player");
                                    }
                            */
                            JOptionPane.showMessageDialog(null, "Passing Turn");
                        } else {
                            //nextplayer
                            changeTurn();
                            JOptionPane.showMessageDialog(null, "Next Player");
                        }
                    } else if (result.equals("PERDE")) {
                        JOptionPane.showMessageDialog(null, "Passing turn");
                        changeTurn();
                    }
                    else  if (result.equals("JOLLY")){
                        JOptionPane.showMessageDialog(null, "Lucky you");
                        //salva il jolly
                        /* if(posseduti)
                            salva;
                            else
                            do nothing;
                         */

                    }
                    else {
                        int x = Integer.parseInt(result);
                        String consonantCalled = JOptionPane.showInputDialog("Write the Consonant");
                        int n = consonantCalled.charAt(0); //inserire metodo di ricerca n consonanti dell'array
                        //check con secret word
                        if (n>0) { //consonantCalled.charAt(0)
                            //metodo di ricostruzione gridlayout         secretWordTable(jPanelCenter, "prova uno");
                            int resultPoints = n*x;
                            money += resultPoints;
                            updatePoints(money);
                            JOptionPane.showMessageDialog(null, "Gained " + resultPoints);
                            JOptionPane.showMessageDialog(null, "Select your next move");

                            //send points to total in db (event to change total score)
                            //new turn same player
                        } else if(jollyBox.isSelected()) {
                           /* if(possiede jolly){
                                    JOptionPane.showMessageDialog(null, "Wrong Answer, using Jolly");
                                    changeTurn(true);//override a stesso player
                                }
                                else{
                                  //nextplayer
                                    changeTurn();
                                    JOptionPane.showMessageDialog(null, "Next Player");
                                    }
                            */
                            JOptionPane.showMessageDialog(null, "Passing Turn");
                        } else {
                            //nextplayer
                            changeTurn();
                            JOptionPane.showMessageDialog(null, "Next Player");
                        }
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Wait for your turn");

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
        //pass button
        passButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                if (myTurn){
                    changeTurn();
                    JOptionPane.showMessageDialog(null, "Turn passed");
                    //event to db
                }
                else
                    JOptionPane.showMessageDialog(null, "Wait for your turn");

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

        //vowel button
        vowelButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                if (myTurn && !firstTurn &&money>1000){ //inserire condizione soldi insufficenti

                    //-1000 punti e metodo per aggiornare punti sul server
                    money-=1000;
                    updatePoints(money);

                    String vowelCalled = JOptionPane.showInputDialog("Write the Vowel");
                    //temporizzatore 5s
                    if (vowelCalled.equals("a")){ //usare l'array di vocali presenti

                        //update
                        JOptionPane.showMessageDialog(null, "Vowel present");

                        //        secretWordTable(jPanelCenter, "prova uno");

                    } else{
                        changeTurn();
                        JOptionPane.showMessageDialog(null, "Vowel not Present");
                    }

                }else if (firstTurn) {
                    JOptionPane.showMessageDialog(null, "You can't call a vowel in the first turn");
                }else if (money<1000) {
                    JOptionPane.showMessageDialog(null, "Not enough points");

                } else
                    JOptionPane.showMessageDialog(null, "Wait for your turn");

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




        //pannels
        //player and player scores
        JPanel jPanelWest = new JPanel(new GridLayout(3,2));

        //Secret Word label
        JPanel jPanelCenter = new JPanel(new GridLayout(4,15));

        //action buttons (per ora)
        JPanel jPanelSouth = new JPanel(new GridLayout(2,2));

        //center Big Box
        JPanel jPanelCenterContainer = new JPanel(new GridLayout(2,2));


        //inside jPanelCenterContainer 3rd box
        playerActive = "player xxx"; //tipo Player e inserire un getPlayerPlaying() per ottenere il giocatore attivo
        String movePlayerX = "Turning the wheel"; //getPlayerXMove() da la mossa e il risultato della stessa
        JPanel jPanelPlayerMoves = new JPanel(new BorderLayout());
        JTextField jTextFieldPlayerPlaying = new JTextField("Player active: " /*+playerX*/);
        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        textArea.append(movePlayerX);

        //panel Left
        JLabel player1 = new JLabel("Player 1"); //get players
        JLabel player2 = new JLabel("Player 2");
        JLabel player3 = new JLabel("Player 3");
        JTextField jTextField1 = new JTextField("Points: " + moneyA[0]); //get x point
        JTextField jTextField2 = new JTextField("Points: " + moneyA[0]);
        JTextField jTextField3 = new JTextField("Points: " + moneyA[0]);

        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);

        jPanelWest.add(player1);
        jPanelWest.add(jTextField1);

        jPanelWest.add(player2);
        jPanelWest.add(jTextField2);

        jPanelWest.add(player3);
        jPanelWest.add(jTextField3);


        getContentPane().add(jPanelWest, BorderLayout.LINE_START);
        getContentPane().add(jollyBox, BorderLayout.SOUTH);



        //secret word ---  jPanelCenter  ---- aggiornare ad ogni turno quando riottieni la stringa
        secretWordTable(jPanelCenter, nWords ,cSecretWord, charsRelatedValues);




        //add content to the big Box
        jPanelCenterContainer.add(jPanelCenter);
        jPanelCenterContainer.add(imageLB);
        //adding to big box 3rd square
        jPanelPlayerMoves.add(jTextFieldPlayerPlaying, BorderLayout.NORTH); //mettere if in base alla mossa
        jPanelPlayerMoves.add(scrollPane, BorderLayout.CENTER);
        jPanelCenterContainer.add(jPanelPlayerMoves);

        //panel South
        jPanelSouth.add(answerButton); //timer 10s
        //insert eventListener for win and dialog ("you win" or "playerx win")

        jPanelSouth.add(passButton);
        jPanelSouth.add(vowelButton); //verifica punti >1000
        jPanelSouth.add(wheelButton);


        jPanelCenterContainer.add(jPanelSouth);
        //getContentPane().add(jPanelSouth, BorderLayout.SOUTH);


        getContentPane().add(jPanelCenterContainer, BorderLayout.CENTER);






        //jframe operative stuff
        setSize(getScreenDim());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private boolean sameChar (char c, char [] chars){
        boolean result = false;
        for (char aChar : chars) {
            if (c == aChar) {
                result = true;
                return result;
            }
        }
        return result;
    }

    private void secretWordTable(JPanel jPanel, int nWords, char[] cSecretWord, boolean [] charsRelatedValues) {
        int totChars = cSecretWord.length;
        String unknown = "?";
        int j = 0;
        if (totChars > 60-nWords || totChars== 0)
            JOptionPane.showMessageDialog(null, "Word missing or too long");
        else{
            while (j<totChars){
                if (cSecretWord[j] == ' '){
                    JPanel cell = new JPanel();
                    cell.setBackground(Color.BLACK);
                    jPanel.add(cell);
                    j++;
                }else{
                    if (charsRelatedValues[j]) {
                        JLabel cell = new JLabel(Character.toString(cSecretWord[j]), SwingConstants.CENTER);
                        jPanel.add(cell);
                        j++;
                    } else {
                        JLabel cell = new JLabel(unknown, SwingConstants.CENTER);
                        jPanel.add(cell);
                        j++;
                    }
                }
            }
        }
        if (totChars < 60){
            for (int coutn = totChars; coutn<60; coutn++){
                JPanel cell = new JPanel();
                cell.setBackground(Color.BLACK);
                jPanel.add(cell);
            }
        }
    }


    private void disableButtons (JButton b, JButton b1, JButton b2, JButton b3){
        b.setEnabled(false);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);

    }
    //overloading per il primo turno (solo gira la ruota)
    private void disableButtons (JButton b, JButton b1, JButton b2){
        b.setEnabled(false);
        b1.setEnabled(false);
        b2.setEnabled(false);

    }

    private Dimension getScreenDim(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
    private boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' )
            return true;
        else
            return false;
    }

    //chiede al server se è il primo turno della partita (per ogni nuova parola mettere valore false)
    void setTurn (boolean tf){
        firstTurn = tf;
    }
    //chiede al server se è il turno del giocatore del client (disabilita i bottoni e le varie operazioni)
    void setMyTurn (boolean tf){
        myTurn = tf;
    }
    //server gira la ruota e setta il risultato (punteggio, passa, perde o jolly) in argomento al metodo
    void setResultWheel (String result){
        resultWheel = result;
    }

    //chiamata di cambio turno che parla con il server per passare il turno al prossimo giocatore
    private void changeTurn (){
        //chiamata metodo server per player successivo
    }
    //override nel caso dell'uso di jolly, il turno rimane al giocatore attivo
    private void changeTurn (Boolean me){
        //turn stays to current player
    }
    // al termine del turno e al primo turno il server manda la stringa con il giocatore attivo
    void setPlayerActive (String player){
        playerActive = player;
    }

    //il server manda la string con la mossa fatta e i punti (in formato stringa) (se previsti dalla mossa)
    String setMoveMade (String movePoint){
        return  movePoint;
    }
    //metodo per inviare la mossa al server
    String moveMade (String move){
        //chiamata a qualcosa del server getMove()?
        return move;
    }
    //metodo per inviare i punti al server e conteggiare
    int pointsScored (int points){
        //chiamata a qualcosa del server se la mossa lo prevede getPoints()?
        return points;
    }

    int vowelCall (){
        //chiamata a qualcosa del server per sottrarre i punti dal giocatore per la vocale chiamata
        return -1000;
    }

    void updatePoints(int money){
        //update money
    }
    void setPoints(int money){

    }
    //override per diversi giocatori ( per il tabellone) player 1-2 o 3
    void setPoints(int money, int player){
        //mettere variabile punti
        moneyA[player-1] = money;
    }

    int whichPlayer (){
        //getPlayerperClient
        return 1;
    }
}