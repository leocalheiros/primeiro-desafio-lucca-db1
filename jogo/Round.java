package jogo;

public class Round {
    private Player player1;
    private Player player2;
    private String result;

    public boolean checkWinner(Move move, Move otherMove){
        return (move == Move.ROCK && otherMove == Move.SCISSOR) ||
                (move == Move.PAPER && otherMove == Move.ROCK) ||
                (move == Move.SCISSOR && otherMove == Move.PAPER);
    }

    public Round(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.result = getWinner();
    }
    public String getWinner(){
        if (checkWinner(player1.getMove(),player2.getMove())){
            return player1.getName() + " wins!";
        } else if (checkWinner(player2.getMove(), player1.getMove())){
            return player2.getName() + " wins!";
        } else{
            return "Draw!";
        }
    }

    public String getResult(){
        return this.result;
    }

    @Override
    public String toString(){
        return result;
    }
}