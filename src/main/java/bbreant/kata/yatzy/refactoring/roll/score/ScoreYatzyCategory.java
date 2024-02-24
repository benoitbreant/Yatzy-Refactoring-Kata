package bbreant.kata.yatzy.refactoring.roll.score;

import bbreant.kata.yatzy.refactoring.roll.Roll;

public class ScoreYatzyCategory implements ScoreStrategy {
    @Override
    public int score(Roll roll) {
        if (ScoreStrategy.groupDiceByValue(roll).size() == 1) {
            return 50;
        } else return 0;
    }

}
