package bbreant.kata.yatzy.refactoring;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.TypedArgumentConverter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringToRollArgumentConverter extends TypedArgumentConverter<String, Roll> {
    protected StringToRollArgumentConverter() {
        super(String.class, Roll.class);
    }

    @Override
    protected Roll convert(String source) throws ArgumentConversionException {
        if (source == null || source.isBlank()) {
            return new Roll(Collections.emptyList());
        } else {
            List<Integer> dice = Arrays.stream(source.split("\\|")).map(String::trim).map(Integer::valueOf).toList();
            return new Roll(dice);
        }
    }
}