package jogo;

public class Jogador {

    private String nome;
    private Escolha escolha;

    public String getNome(){
        return this.nome;
    }

    public Escolha getEscolha(){
        return escolha;
    }

    public void setEscolha(Escolha escolha){
        this.escolha = escolha;
    }

    public Jogador(String nome){
        this.nome = nome;
    }
}
