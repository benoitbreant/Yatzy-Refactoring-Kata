package bbreant.kata.yatzy.refactoring.roll.score;

import bbreant.kata.yatzy.refactoring.roll.Roll;

import java.util.Map;
import java.util.Optional;

public class ScoreMultipleOfAKindCategory implements ScoreStrategy {

    int numberOfAKind;


    public ScoreMultipleOfAKindCategory(int numberOfAKind) {
        this.numberOfAKind = numberOfAKind;
    }

    @Override
    public int score(Roll roll) {
        Optional<Integer> multipleOfAKindValue = ScoreStrategy.groupDiceByValue(roll).entrySet().stream().filter(x -> x.getValue() >= this.numberOfAKind).map(Map.Entry<Integer, Long>::getKey).reduce(Integer::max);
        return multipleOfAKindValue.map(integer -> integer * numberOfAKind).orElse(0);
    }

}
