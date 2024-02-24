package bbreant.kata.yatzy.refactoring;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Roll {
    final List<Integer> dice;

    public Roll(List<Integer> dice) {
        this.dice = Objects.requireNonNullElse(dice, Collections.emptyList());
    }

    public List<Integer> getDice() {
        return dice;
    }

    public int sumOfAllDice() {
        return this.dice.stream().reduce(0, Integer::sum);
    }

    public Map<Integer, Long> groupDiceByValue() {
        return dice.stream().collect(Collectors.groupingBy(dieValue -> dieValue, Collectors.counting()));
    }
}
