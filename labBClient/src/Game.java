public class Game {
    private int startingPlayer = (int) Math.floor((Math.random()*3) % 3); //0, 1 o 2, posizione nell'array giocatori
    private int currentRound = 0;
    private Boolean over = false; //solo per controllo se una partita è in corso o no (per osservatori)
    private PlayerRdF[] arrayPlayers = new PlayerRdF[3];
    private Round[] arrayRound = new Round[5];
    private Boolean[] arrayJoly = new Boolean[3];

    public Game(){


        //qui scelta frasi?
        for (int i = 0; i < 5; i++){
            arrayRound[i] = new Round(i);
        }
        arrayRound[0].setFirstPlayer(startingPlayer);

        for (int i = 0; i < 5; i++){
            //arrayRound[i].play();
        }
        over = true;

    }

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
}
