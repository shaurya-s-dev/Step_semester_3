package week1.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0, losses = 0, draws = 0;
        int rounds = 5;

        System.out.println("=== Rock-Paper-Scissors ===");
        for (int i = 1; i <= rounds; i++) {
            System.out.print("Round " + i + " - Your move (Rock/Paper/Scissors): ");
            String player = sc.next();
            String computer = moves[rand.nextInt(3)];
            String result = playRound(player, computer);
            System.out.println("Computer: " + computer + " -> " + result);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        double winPercent = (wins * 100.0) / rounds;
        System.out.println("\n=== Final Summary ===");
        System.out.println("Wins: " + wins + " / Losses: " + losses + " / Draws: " + draws);
        System.out.printf("Win %% = %.1f%%\n", winPercent);
        sc.close();
    }
}