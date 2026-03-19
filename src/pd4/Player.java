package pd4;

import java.util.Arrays;
import java.util.Comparator;

public class Player implements Comparable<Player> {
    private final String name;
    private int[] scores = new int[3];

    public Player(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
    }


    public int getScoreSum() {
        int scoreSum = scores[0];
        for (int i = 1; i < scores.length; i++) {
            scoreSum += scores[i];
        }
        return scoreSum;
    }

    public double getAverageScore(){
        return getScoreSum() / 3.0;
    }

    public int getSmallestScore(){
        int  smallestScore = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < smallestScore) {
                smallestScore = scores[i];
            }
        }
        return smallestScore;
    }
    public int getLargestScore(){
        int largestScore = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > largestScore) {
                largestScore = scores[i];
            }
        }
        return largestScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    public int compareTo(Player other) {
        return -(this.getScoreSum() - other.getScoreSum());
    }



}
