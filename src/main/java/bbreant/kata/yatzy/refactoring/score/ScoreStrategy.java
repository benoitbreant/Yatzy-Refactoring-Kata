package bbreant.kata.yatzy.refactoring.score;

import bbreant.kata.yatzy.refactoring.Roll;

import java.util.Map;
import java.util.stream.Collectors;

public interface ScoreStrategy {
    int score(Roll roll);

}
