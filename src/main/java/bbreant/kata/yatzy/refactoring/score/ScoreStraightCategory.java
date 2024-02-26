package bbreant.kata.yatzy.refactoring.score;

import bbreant.kata.yatzy.refactoring.Roll;

import java.util.Map;

public class ScoreStraightCategory implements ScoreStrategy {

    final int unwantedNumber;

    public ScoreStraightCategory(int unwantedNumber) {
        this.unwantedNumber = unwantedNumber;
    }

    @Override
    public int score(Roll roll) {
        Map<Integer, Long> diceByValue = roll.groupDiceByValue();
        if (diceByValue.size() == 5 && !diceByValue.containsKey(this.unwantedNumber)) {
            return roll.sumOfAllDice();
        } else return 0;
    }
}
