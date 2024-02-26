package bbreant.kata.yatzy.refactoring.score;

import bbreant.kata.yatzy.refactoring.roll.Roll;

import java.util.Map;
import java.util.Optional;

public class ScoreMultipleOfAKindCategory implements ScoreStrategy {

    final int expectedNumberOfAKind;

    public ScoreMultipleOfAKindCategory(int expectedNumberOfAKind) {
        this.expectedNumberOfAKind = expectedNumberOfAKind;
    }

    @Override
    public int score(Roll roll) {
        Optional<Integer> valueOfKindThatIsMoreThanExpectedNumber = roll.groupDiceByValue().entrySet().stream().filter(entry -> entry.getValue() >= this.expectedNumberOfAKind).map(Map.Entry::getKey).reduce(Integer::max);
        return valueOfKindThatIsMoreThanExpectedNumber.map(valueOfKind -> valueOfKind * this.expectedNumberOfAKind).orElse(0);
    }

}
