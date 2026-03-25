package pd4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static int getIndexOfMaxScore(Player[] players) {
        int indexOfMaxScore = 0;
        int largestScore = players[0].getLargestScore();
        for (int i = 1; i < players.length; i++) {
            if (players[i].getLargestScore() > largestScore) {
                largestScore = players[i].getLargestScore();
                indexOfMaxScore = i;
            }
        }
        return indexOfMaxScore;
    }

    public static int[] getScoreFromUser() {
        int[] scores = new int[3];
        for (int j = 0; j < 3; j++) {
            System.out.printf("Podaj %d wynik: ", j + 1);
            scores[j] = scanner.nextInt();
            scanner.nextLine();
        }
        return scores;
    }


    public static void main(String[] args) {
        int amountOfPlayers;
        do {
            System.out.println("Podaj liczbę graczy z zakresu 2 - 10");
            amountOfPlayers = scanner.nextInt();
        } while (amountOfPlayers < 2 || amountOfPlayers > 10);

        scanner.nextLine();
        Player[] players = new Player[amountOfPlayers];
        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.printf("Podaj imię gracza numer %d: ", i + 1);
            String name = scanner.nextLine();
            players[i] = new Player(name, getScoreFromUser());

        }
        Arrays.sort(players);
        for (int i = 0; i < amountOfPlayers; i++) {
            if (i == getIndexOfMaxScore(players)) {
                System.out.println(i + 1 + ".*" + players[i].getInformationWithStatistics());
            } else {
                System.out.println(i + 1 + ". " + players[i].getInformationWithStatistics());
            }
        }

        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.printf("%d miejsce %s%n", i + 1, players[i].getName());
        }
        scanner.close();
    }

}
