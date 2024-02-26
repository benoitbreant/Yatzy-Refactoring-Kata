package bbreant.kata.yatzy.refactoring.score;

import bbreant.kata.yatzy.refactoring.roll.Roll;

public class ScoreFullHouseCategory implements ScoreStrategy {


    @Override
    public int score(Roll roll) {
        if(roll.groupDiceByValue().size() == 2){
            return roll.sumOfAllDice();
        } else return 0;
    }

}
