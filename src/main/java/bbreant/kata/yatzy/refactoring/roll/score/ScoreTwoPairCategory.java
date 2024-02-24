package bbreant.kata.yatzy.refactoring.roll.score;

import bbreant.kata.yatzy.refactoring.roll.Roll;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreTwoPairCategory implements ScoreStrategy {


    @Override
    public int score(Roll roll) {
        List<Integer> pairValues = ScoreStrategy.groupDiceByValue(roll).entrySet().stream().filter(x -> x.getValue() >= 2).map(Map.Entry<Integer, Long>::getKey).collect(Collectors.toList());

        if (pairValues.size() >= 2) {
            return pairValues.stream().reduce(Integer::sum).map(integer -> integer * 2).orElse(0);
        } else {
            return 0;
        }
    }

}
