package bbreant.kata.yatzy.refactoring.roll;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Roll {
    final List<Integer> dice;

    public Roll(List<Integer> dice) {
        this.dice = Objects.requireNonNullElse(dice, Collections.emptyList());
    }

    public List<Integer> getDice() {
        return dice;
    }
}
