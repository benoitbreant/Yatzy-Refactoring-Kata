package bbreant.kata.yatzy.refactoring.score;

import bbreant.kata.yatzy.refactoring.Roll;

import java.util.List;
import java.util.Map;

public class ScoreTwoPairCategory implements ScoreStrategy {


    @Override
    public int score(Roll roll) {
        List<Integer> pairValues = roll.groupDiceByValue().entrySet().stream().filter(entry -> entry.getValue() >= 2).map(Map.Entry::getKey).toList();

        if (pairValues.size() == 2) {
            return pairValues.stream().reduce(Integer::sum).map(sumOfPairValues -> sumOfPairValues * 2).orElse(0);
        } else {
            return 0;
        }
    }

}
