package bbreant.kata.yatzy.refactoring;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.TypedArgumentConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToRollArgumentConverter extends TypedArgumentConverter<String, Roll> {
    protected StringToRollArgumentConverter() {
        super(String.class, Roll.class);
    }

    @Override
    protected Roll convert(String source) throws ArgumentConversionException {
        if (source == null) {
            return null;
        } else if (source.isEmpty()) {
            return new Roll(null);
        } else {
            List<Integer> dice = Arrays.stream(source.split("\\|")).map(String::trim).map(Integer::valueOf).collect(Collectors.toList());
            return new Roll(dice);
        }
    }
}