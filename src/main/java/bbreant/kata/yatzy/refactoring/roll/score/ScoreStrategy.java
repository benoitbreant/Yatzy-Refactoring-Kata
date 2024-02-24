package bbreant.kata.yatzy.refactoring.roll.score;

import bbreant.kata.yatzy.refactoring.roll.Roll;

import java.util.Map;
import java.util.stream.Collectors;

public interface ScoreStrategy {
    int score(Roll roll);

    static int sumOfAllDice(Roll roll) {
        return roll.getDice().stream().reduce(0, Integer::sum);
    }

    static Map<Integer, Long> groupDiceByValue(Roll roll) {
        return roll.getDice().stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    }
}
