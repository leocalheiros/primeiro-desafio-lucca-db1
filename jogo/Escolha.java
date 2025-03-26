package jogo;

public enum Escolha {
    PEDRA("Pedra"),
    PAPEL("Papel"),
    TESOURA("Tesoura");

    private String escolha;

    Escolha (String escolha){
        this.escolha = escolha;
    }
    public String getEscolha(){
        return escolha;
    }
    @Override
    public String toString() {
        return escolha;
    }

    public boolean verificarVencedor(Escolha outra){
        return (this == PEDRA && outra == TESOURA) ||
                (this == PAPEL && outra == PEDRA) ||
                (this == TESOURA && outra ==PAPEL);
    }
}