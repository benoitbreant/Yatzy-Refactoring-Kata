package bbreant.kata.yatzy.refactoring.score;

import bbreant.kata.yatzy.refactoring.Roll;

public class ScoreNumbersCategory implements ScoreStrategy {

    int categoryNumber;

    public ScoreNumbersCategory(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }

    @Override
    public int score(Roll roll) {
        return roll.getDice().stream().filter(dieValue -> dieValue == this.categoryNumber).reduce(0, Integer::sum);
    }
}
