class Round {
    private String SecretSentence;
    private int currentPlayer;
    private int roundNumber;
    private boolean over;
    private int[] arrayScore = new int[3];
    private PlayerRdF[] arrayPlayers = new PlayerRdF[3];
    private Game game;

    Round(int n, Game currentGame){
        game = currentGame;
        roundNumber = n; //serve?
        over = false;
        for (int i = 0; i < 3; i++){
            arrayScore[i] = 0; //inizializzo gli score a 0 - sono già a 0 di default? pensavo fossero null
        }

        setSecretSentence("prova"); //TODO ?
    }

    void play() {
        while(!over){
            //TODO inserire un listener per l'UI che gestisce l'oggetto di classe Round corrispondente
            switch (giraLaRuota(arrayPlayers[currentPlayer])){
                case "Points": checkConsonant(); break; //fare con UI
                case "Lose": removePlayerFromRound(currentPlayer); break;
                case "Pass": break; //+check jolly
                case "Jolly": game.addJolly(currentPlayer);
            }
            //TODO azione successiva scelta dall'utente tramite UI
            /*switch (azione)
            * case vari
            * ...
            * checkSolution(guess) se indovina: aggiorna punti e over = true;
            */
            }
        game.nextRound();

        }
            //currentPlayer = (currentPlayer + 1) % 3 <---passaggio di turno
        /*logica della partita:
    1) determinare casualmente giocatore iniziale (poi a rotazione)
    2) mostrare lettere frase e tema
    3) turno di gioco
        3check)se tutte le consonanti sono state trovate, non permettere più di girare la ruota
        3a) gira la ruota -> effetto della casella (jolly rigira la ruota)
        3b) 5 secondi per chiamare una consonante -> se la consonante non è presente, se chiama una vocale, non fa in tempo o prova a dare la soluzione, passa il turno
            se la consonante è presente -> punti, rivelare caselle con la consonante e passa a 3c
        3c) 5 secondi per   girare la ruota di nuovo
                            dare la soluzione entro 10 secondi, se è giusta allora vince il suo punteggio, altrimenti se è sbagliata o finiscono i 10 secondi, passa
                            comprare una vocale per 1000 punti, se è presente tocca ancora al giocatore, invece se non è presente, chiama una consonante, o finisce il tempo, passa

    jolly? userei un checkbox per determinare preventivamente se il giocatore vuole usarlo

    * */


    void setFirstPlayer(int n){
        currentPlayer = n;
    }

    private String giraLaRuota(PlayerRdF player){
        int randomMove = (int) Math.floor((Math.random()*4) % 4);
        switch (randomMove){
            case 0: return "Points";
            case 1: return "Lose";
            case 2: return "Pass";
            case 3: return "Jolly";
        }
        return "Error";
    }

    void setSecretSentence(String sentence){
        if (SecretSentence == null) {
            SecretSentence = sentence;
        }
    }

    private int checkConsonant(){
        int score = 0; //score 0 = no consonante, altrimenti calcolo punteggio
        //if (consonantePresente) score = punteggio * numero consonanti
        return score;
    }

    private void checkSolution(String guess){
        //if (SecretSentence == guess) win, end round
        // else pass
    }

    private void removePlayerFromRound(int player){
        //TODO
    }
    PlayerRdF getCurrentPlayer(){
        return arrayPlayers[currentPlayer];
    }
}
