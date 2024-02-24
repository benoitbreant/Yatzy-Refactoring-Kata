package bbreant.kata.yatzy.refactoring.roll.score;

import bbreant.kata.yatzy.refactoring.roll.Roll;

public class ScoreNumbersCategory implements ScoreStrategy {

    int categoryNumber;


    public ScoreNumbersCategory(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }

    @Override
    public int score(Roll roll) {
        return roll.getDice().stream().filter(d -> d == this.categoryNumber).reduce(0, Integer::sum);
    }
}
