package jogo;

import jdk.net.ExtendedSocketOptions;


import java.beans.PropertyEditorSupport;
import java.util.LinkedList;

import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Round> matchHistory = new LinkedList<>();

    private Move getMove(String name, Scanner scanner){
        Move move = null;
        boolean valid = false;
        while (!valid){
            System.out.println(name + " Choose your move (ROCK, SCISSOR OR PAPER): ");
            try {
                move = Move.valueOf(scanner.next().toUpperCase());
                valid = true;
            } catch (IllegalArgumentException e){
                System.out.println("Invalid Move! Try again.");
            }
        }
        return move;

    }

    private void addRoundToHistory(Round round) {
        if (matchHistory.size() >= 5) {
            matchHistory.removeFirst();
        }
        matchHistory.add(round);
    }

    private void showHistory(){
        System.out.println("\n"+"=".repeat(30) +"\n"+"Match History of the last 5 games: "+"\n");
        for(Round round: matchHistory){
            System.out.println(round);
        }
        System.out.println("\n"+"=".repeat(30)+"\n");
    }

    private static boolean equalsTo(String expected, String typed){
        if (typed == null || typed.length() != 1) return false;
        return expected.toLowerCase().contains(typed.toLowerCase());

    }
    public void start(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter player 1's name : ");
        Player player1 = new Player(scanner.nextLine());

        System.out.println("\n"+"Enter player 2's name: ");
        Player player2 = new Player(scanner.nextLine());

        String answer = "";
        while (!equalsTo("n",answer)){
            player1.setMove(getMove(player1.getName(),scanner));
            player2.setMove(getMove(player2.getName(),scanner));

            Round round = new Round(player1, player2);
            addRoundToHistory(round);

            System.out.println("\n".repeat(2)+round);

            showHistory();

            System.out.println(" Do you wanna play again [Y / N] : ");
            answer = scanner.next().toLowerCase();
            while (!equalsTo("yn",answer)){
                System.out.println("Invalid Answer! Please type [Y]es or [N]o: ");
                answer = scanner.next().toLowerCase();
            }
            scanner.nextLine();
        }
        scanner.close();
    }
    public static void main(String[] args){
        Game game = new Game();
        game.start();
    }
}
