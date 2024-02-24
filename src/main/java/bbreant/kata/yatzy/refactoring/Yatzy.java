package bbreant.kata.yatzy.refactoring;

public class Yatzy {

    public int scoreRollOnCategory(Roll roll, Category category) {
        return category.getScoreStrategy().score(roll);
    }

}



