package jogo;

public enum Move {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSOR("Scissor");

    private String move;

    Move(String move) {
        this.move = move;
    }

    public String getMove() {
        return move;
    }

    @Override
    public String toString() {
        return move;
    }
}