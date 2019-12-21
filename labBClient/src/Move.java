public class Move {
    private String move;

    public Move(String m) { //costruttore
        switch (m) {
            case "buy":
                move = "buyVowel";
                buyVowel();
                break;

            case "callC":
                move = "callC";
                callConsonant();
                break;

            case "callS":
                move = "callS";
                callSolution();
                break;

            case "jolly":
                move = "jolly";
                useJolly();
                break;
        }
    }

    public String getMove() {
        return move;
    }

    private void buyVowel(){
        //effetto
    }

    private void callConsonant(){
        //effetto
    }

    private void callSolution(){
        //effetto
    }

    private void useJolly(){
        //effetto
    }



}
