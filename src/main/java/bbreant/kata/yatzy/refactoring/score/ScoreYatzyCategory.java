package bbreant.kata.yatzy.refactoring.score;

import bbreant.kata.yatzy.refactoring.roll.Roll;

public class ScoreYatzyCategory implements ScoreStrategy {
    @Override
    public int score(Roll roll) {
        if (roll.groupDiceByValue().size() == 1) {
            return 50;
        } else return 0;
    }

}
