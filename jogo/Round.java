package jogo;

public class Round {
    private Player player1;
    private Player player2;
    private String result;

    public Round(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.result = getWinner();
    }
    public String getWinner(){
        if (player1.getMove().getWinner(player2.getMove())){
            return player1.getName() + " wins!";
        } else if (player2.getMove().getWinner(player1.getMove())){
            return player2.getName() + " wins!";
        } else{
            return " Draw!";
        }
    }

    public String getResult(){
        return this.result;
    }

    @Override
    public String toString(){
        if(player1.getMove().getWinner(player2.getMove())){
            return result + "|"+ player1.getMove()+" vs "+ player2.getMove();
        } else if(player2.getMove().getWinner(player1.getMove())) {
            return result + "|"+ player2.getMove()+" vs "+ player1.getMove();
        } else{
            return result;
        }

    }
}