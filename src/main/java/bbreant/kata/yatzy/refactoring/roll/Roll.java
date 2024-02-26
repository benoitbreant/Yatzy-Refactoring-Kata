package bbreant.kata.yatzy.refactoring.roll;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Roll(List<Integer> dice) {
    public Roll(List<Integer> dice) {
        this.dice = Stream.ofNullable(dice).flatMap(Collection::stream).filter(Objects::nonNull).toList();
    }

    @Override
    public List<Integer> dice() {
        return Collections.unmodifiableList(this.dice);
    }

    public int sumOfAllDice() {
        return this.dice.stream().reduce(0, Integer::sum);
    }

    public Map<Integer, Long> groupDiceByValue() {
        return dice.stream().collect(Collectors.groupingBy(dieValue -> dieValue, Collectors.counting()));
    }
}
