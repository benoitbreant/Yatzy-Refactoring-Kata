package bbreant.kata.yatzy.refactoring.score;

import bbreant.kata.yatzy.refactoring.category.Category;

import static bbreant.kata.yatzy.refactoring.category.YatzyCategory.*;


public class ScoreStrategyFactory {

    public static ScoreStrategy getScoreStrategy(Category category) {
        return switch (category) {
            case CHANCE -> new ScoreChanceCategory();
            case YATZY -> new ScoreYatzyCategory();
            case ONES -> new ScoreNumbersCategory(1);
            case TWOS -> new ScoreNumbersCategory(2);
            case THREES -> new ScoreNumbersCategory(3);
            case FOURS -> new ScoreNumbersCategory(4);
            case FIVES -> new ScoreNumbersCategory(5);
            case SIXES -> new ScoreNumbersCategory(6);
            case PAIR -> new ScoreMultipleOfAKindCategory(2);
            case TWO_PAIRS -> new ScoreTwoPairCategory();
            case THREE_OF_A_KIND -> new ScoreMultipleOfAKindCategory(3);
            case FOUR_OF_A_KIND -> new ScoreMultipleOfAKindCategory(4);
            case SMALL_STRAIGHT -> new ScoreStraightCategory(6);
            case LARGE_STRAIGHT -> new ScoreStraightCategory(1);
            case FULL_HOUSE -> new ScoreFullHouseCategory();
            default -> throw new IllegalStateException("Unexpected category: " + category);
        };
    }
}