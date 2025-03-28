package jogo;


public class Player {

    private String name;
    private Move move;

    public String getName() {
        return this.name;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Player(String name) {
        this.name = name;
    }
}
