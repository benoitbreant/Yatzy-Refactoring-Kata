package bbreant.kata.yatzy.refactoring;

import bbreant.kata.yatzy.refactoring.score.*;

public enum Category {


    CHANCE {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreChanceCategory();
        }
    },

    YATZY {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreYatzyCategory();
        }
    },
    ONES {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreNumbersCategory(1);
        }
    },

    TWOS {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreNumbersCategory(2);
        }
    },

    THREES {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreNumbersCategory(3);
        }
    },

    FOURS {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreNumbersCategory(4);
        }
    },

    FIVES {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreNumbersCategory(5);
        }
    },

    SIXES {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreNumbersCategory(6);
        }
    },

    PAIR {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreMultipleOfAKindCategory(2);
        }
    },

    TWO_PAIRS {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreTwoPairCategory();
        }
    },

    THREE_OF_A_KIND {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreMultipleOfAKindCategory(3);
        }
    },

    FOUR_OF_A_KIND {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreMultipleOfAKindCategory(4);
        }
    },

    SMALL_STRAIGHT {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreStraightCategory(6);
        }
    },

    LARGE_STRAIGHT {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreStraightCategory(1);
        }
    },

    FULL_HOUSE {
        @Override
        ScoreStrategy getScoreStrategy() {
            return new ScoreFullHouseCategory();
        }
    };

    abstract ScoreStrategy getScoreStrategy();

}
