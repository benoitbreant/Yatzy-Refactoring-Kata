package bbreant.kata.yatzy.refactoring.roll.score;

import bbreant.kata.yatzy.refactoring.roll.Roll;

public class ScoreFullHouseCategory implements ScoreStrategy {


    @Override
    public int score(Roll roll) {
        if(ScoreStrategy.groupDiceByValue(roll).size() == 2){
            return ScoreStrategy.sumOfAllDice(roll);
        } else return 0;
    }

}
