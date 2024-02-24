package bbreant.kata.yatzy.refactoring.roll.score;

import bbreant.kata.yatzy.refactoring.roll.Roll;

public class ScoreStraightCategory implements ScoreStrategy {


    @Override
    public int score(Roll roll) {
        if(ScoreStrategy.groupDiceByValue(roll).size() >= 5){
            return ScoreStrategy.sumOfAllDice(roll);
        } else return 0;
    }
}
