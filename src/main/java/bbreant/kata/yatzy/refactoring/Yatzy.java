package bbreant.kata.yatzy.refactoring;

import bbreant.kata.yatzy.refactoring.roll.Roll;
import bbreant.kata.yatzy.refactoring.roll.score.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Yatzy {

    private final Roll roll;


    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
        this.roll = new Roll(Arrays.stream(dice).boxed().collect(Collectors.toList()));
    }

    public int scoreRoll(ScoreStrategy strategy) {
        return strategy.score(roll);
    }

    public int twoPair() {
        return scoreRoll(new ScoreTwoPairCategory());
    }

    public int fourOfAKind() {
        return scoreMultipleOfAKindCategory(4);
    }

    public int threeOfAKind() {
        return scoreMultipleOfAKindCategory(3);
    }

    public int smallStraight() {
        return scoreRoll(new ScoreStraightCategory());
    }

    public int largeStraight() {
        return scoreRoll(new ScoreStraightCategory());
    }

    public int fullHouse() {
        return scoreRoll(new ScoreFullHouseCategory());
    }

    public int pair() {
        return scoreMultipleOfAKindCategory(2);
    }

    public int chance() {
        return scoreRoll(new ScoreChanceCategory());
    }

    public int yatzy() {
        return scoreRoll(new ScoreYatzyCategory());
    }

    public int ones() {
        return scoreNumberCategory(1);
    }

    public int twos() {
        return scoreNumberCategory(2);
    }

    public int threes() {
        return scoreNumberCategory(3);
    }

    public int fours() {
        return scoreNumberCategory(4);
    }

    public int fives() {
        return scoreNumberCategory(5);
    }

    public int sixes() {
        return scoreNumberCategory(6);
    }

    private int scoreNumberCategory(int categoryNumber) {
        return scoreRoll(new ScoreNumbersCategory(categoryNumber));
    }

    private int scoreMultipleOfAKindCategory(int numberOfAKind) {
        return scoreRoll(new ScoreMultipleOfAKindCategory(numberOfAKind));
    }
}



