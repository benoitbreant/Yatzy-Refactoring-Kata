package bbreant.kata.yatzy.refactoring;

import java.security.InvalidParameterException;

public class Yatzy {

    public int scoreOfTheRollInACategory(Roll roll, Category category) {
        if (roll == null) {
            throw new InvalidParameterException("Roll is null");
        }
        return category.getScoreStrategy().score(roll);
    }

}



