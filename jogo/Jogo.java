package jogo;

import jdk.net.ExtendedSocketOptions;


import java.beans.PropertyEditorSupport;
import java.util.LinkedList;

import java.util.List;
import java.util.Scanner;

public class Jogo {
    private List<Partida> historico = new LinkedList<>();

    private Escolha obterEscolha(String nome, Scanner scanner){
        while (true){
            System.out.println(nome + " escolha (PEDRA, PAPEL ou Tesoura): ");
            try {
                return Escolha.valueOf(scanner.next().toUpperCase());
            }catch (IllegalArgumentException e){
                System.out.println("Escolha Inválida. Digite novamente.");
            }
        }
    }
    private void adicionarPartidaAoHistorico(Partida partida) {
        if (historico.size() >= 5) {
            historico.removeFirst(); // Remove a partida mais antiga
        }
        historico.add(partida); // Adiciona a nova partida
    }
    private void exibirHistorico(){
        System.out.println("\n"+"=".repeat(42) +"\n"+"Histórico das últimas 5 partidas: "+"\n");
        for(Partida partida: historico){
            System.out.println(partida);
        }
        System.out.println("\n"+"=".repeat(42)+"\n");
    }
    public void iniciar(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do jogador 1: ");
        Jogador jogador1 = new Jogador(scanner.nextLine());

        System.out.println("Digite o nome do jogador 2: ");
        Jogador jogador2 = new Jogador(scanner.nextLine());

        while (true){
            jogador1.setEscolha(obterEscolha(jogador1.getNome(),scanner));
            jogador2.setEscolha(obterEscolha(jogador2.getNome(),scanner));

            Partida partida = new Partida(jogador1, jogador2);
            adicionarPartidaAoHistorico(partida);

            System.out.println(partida.getResultado());

            exibirHistorico();
            String resposta;
            do {
                System.out.println(" Gostaria de jogar novamente [S/N] : ");
                resposta = scanner.next().toLowerCase();
                if (!resposta.equals("s") && !resposta.equals("n")) {
                    System.out.println("Resposta inválida. Por favor, digite 's' ou 'n'.");
                }
            } while (!resposta.equals("s") && !resposta.equals("n"));


            if (resposta.equals("n")) {
                break;
            }
            scanner.nextLine();
        }
        scanner.close();
    }
    public static void main(String[] args){
        new Jogo().iniciar();
    }
}
