package bbreant.kata.yatzy.refactoring.roll.score;

import bbreant.kata.yatzy.refactoring.roll.Roll;

public class ScoreChanceCategory implements ScoreStrategy {

     @Override
    public int score(Roll roll) {
        return ScoreStrategy.sumOfAllDice(roll);
    }


}
