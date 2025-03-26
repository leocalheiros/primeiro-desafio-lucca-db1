package jogo;

public class Partida {
    private Jogador jogador1;
    private Jogador jogardor2;
    private String resultado;

    public Partida(Jogador jogardor1, Jogador jogardor2){
        this.jogador1 = jogardor1;
        this.jogardor2 = jogardor2;
        this.resultado = obterResultado();
    }
    public String obterResultado(){
        if (jogador1.getEscolha().verificarVencedor(jogardor2.getEscolha())){
            return jogador1.getNome() + " venceu!";
        }else if (jogardor2.getEscolha().verificarVencedor(jogador1.getEscolha())){
            return jogardor2.getNome() + " venceu!";
        }else{
            return "Empate!";
        }
    }

    public String getResultado(){
        return this.resultado;
    }

    @Override
    public String toString(){
        if(jogador1.getEscolha().verificarVencedor(jogardor2.getEscolha())){
            return resultado + "|"+jogador1.getEscolha()+" vs "+jogardor2.getEscolha();
        } else if(jogardor2.getEscolha().verificarVencedor(jogador1.getEscolha())) {
            return resultado + "|"+ jogardor2.getEscolha()+" vs "+ jogador1.getEscolha();
        }else{
            return resultado;
        }

    }
}