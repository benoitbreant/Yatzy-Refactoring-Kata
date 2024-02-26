package bbreant.kata.yatzy.refactoring.score;

import bbreant.kata.yatzy.refactoring.roll.Roll;

public interface ScoreStrategy {
    int score(Roll roll);

}
