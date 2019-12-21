public class Round {
    private String SecretSentence;
    private int currentPlayer;
    private int roundNumber;
    private boolean over;
    private int[] arrayScore = new int[3];
    private PlayerRdF[] arrayPlayers = new PlayerRdF[3];

    public Round(int n){
        roundNumber = n;
        over = false;
        for (int i = 0; i < 3; i++){
            arrayScore[i] = 0; //inizializzo gli score a 0
        }

        pickSecretSentence(); //?
    }

    private void play(){
        while(!over){
            //inserire un listener per l'UI che gestisce un oggetto di classe Round corrispondente
            giraLaRuota(arrayPlayers[currentPlayer]);
            //effetti della mossa


            }


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


    public void setFirstPlayer(int n){
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

    private void pickSecretSentence(){

    }

    public int checkConsonant(){
        int score = 0; //score 0 = no consonante, altrimenti calcolo punteggio
        //if (consonantePresente) score = punteggio * numero consonanti
        return score;
    }

    public void checkSolution(String guess){
        //if (SecretSentence == guess) win, end round
        // else pass
    }
}
