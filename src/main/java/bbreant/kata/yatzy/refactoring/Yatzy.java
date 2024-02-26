package bbreant.kata.yatzy.refactoring;

import bbreant.kata.yatzy.refactoring.category.Category;
import bbreant.kata.yatzy.refactoring.roll.Roll;
import bbreant.kata.yatzy.refactoring.score.ScoreStrategyFactory;

import java.security.InvalidParameterException;

public class Yatzy {

    public int scoreOfTheRollInACategory(Roll roll, Category category) {
        if (roll == null) {
            throw new InvalidParameterException("Roll is null");
        }
        return ScoreStrategyFactory.getScoreStrategy(category).score(roll);
    }

}



