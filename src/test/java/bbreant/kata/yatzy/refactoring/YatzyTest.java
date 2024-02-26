package bbreant.kata.yatzy.refactoring;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class YatzyTest {

    static Yatzy yatzy;

    @BeforeAll
    static void beforeAll() {
        yatzy = new Yatzy();
    }

    @Test
    @DisplayName("Roll is null, then throws IllegalArgumentException")
    void when_roll_is_null_then_throws_illegalArgumentException() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> yatzy.scoreOfTheRollInACategory(null, Category.CHANCE),
                "Expected null roll to throw IllegalArgumentException, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("Roll is null"));
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource("3|3|4|5|1,16")
    @DisplayName("Player choose \"chance\" category, then scores sum of all dice")
    void when_chance_then_scores_sum_of_all_dice(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.CHANCE);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "1|1|1|1|1,50",
            "6|6|6|6|6,50"
    })
    @DisplayName("Player choose \"yatzy\" category and all dice have same number, then scores 50")
    void when_yatzy_with_all_dice_having_same_number_then_scores_50(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.YATZY);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource("6|6|6|6|3,0")
    @DisplayName("Player choose \"yatzy\" category and all dice have not same number, then scores 0")
    void when_yatzy_with_all_dice_having_not_same_number_then_scores_0(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.YATZY);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "2|3|4|5|6,0",
            "1|2|3|4|5,1",
            "1|1|1|1|1,5"
    })
    @DisplayName("Player choose \"ones\" category, then scores sum of ones")
    void when_onces_then_scores_sum_of_ones(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.ONES);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "1|3|4|5|6,0",
            "1|2|3|4|2,4",
            "2|2|2|2|2,10"
    })
    @DisplayName("Player choose \"twos\" category, then scores sum of twos")
    void when_twos_then_scores_sum_of_twos(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.TWOS);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "1|2|4|5|6,0",
            "1|2|3|4|3,6",
            "3|3|3|3|3,15"
    })
    @DisplayName("Player choose \"threes\" category, then scores sum of threes")
    void when_threes_then_scores_sum_of_threes(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.THREES);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "1|2|3|5|6,0",
            "1|2|4|3|4,8",
            "4|4|4|4|4,20"
    })
    @DisplayName("Player choose \"fours\" category, then scores sum of fours")
    void when_fours_then_scores_sum_of_fours(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.FOURS);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "1|2|3|4|6,0",
            "1|2|5|4|5,10",
            "5|5|5|5|5,25"
    })
    @DisplayName("Player choose \"fives\" category, then scores sum of fives")
    void when_fives_then_scores_sum_of_fives(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.FIVES);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "1|2|3|4|5,0",
            "1|2|6|5|6,12",
            "6|6|6|6|6,30"
    })
    @DisplayName("Player choose \"sixes\" category, then scores sum of sixes")
    void when_sixes_then_scores_sum_of_sixes(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.SIXES);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "1|2|3|4|5,0"
    })
    @DisplayName("Player choose \"pair\" category but no pair in roll, then scores 0")
    void when_pair_with_less_than_one_pair_then_scores_0(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.PAIR);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "1|2|3|4|3,6",
            "3|3|3|3|3,6"
    })
    @DisplayName("Player choose \"pair\" category and one pair in roll, then scores the sum of two matching dice")
    void when_pair_with_only_one_pair_then_scores_sum_of_two_matching_dice(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.PAIR);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "1|2|5|2|5,10",
            "2|2|5|2|5,10",
            "2|2|5|5|5,10"
    })
    @DisplayName("Player choose \"pair\" category and multiple pair in roll, then scores the sum of two highest matching dice")
    void when_pair_with_more_than_one_pair_then_scores_sum_of_two_highest_matching_dice(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.PAIR);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "1|1|2|3|4,0",
            "1|1|1|3|4,0",
            "1|1|1|1|4,0"
    })
    @DisplayName("Player choose \"two pairs\" category and less than two pairs in roll, then scores 0")
    void when_twoPair_with_less_than_two_pair_then_scores_0(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.TWO_PAIRS);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "3|3|5|4|5,16",
            "3|3|5|5|5,16"
    })
    @DisplayName("Player choose \"two pairs\" category and two pairs in roll, then scores the sum of these dice")
    void when_twoPair_with_two_pair_then_scores_sum_of_these_dice(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.TWO_PAIRS);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "3|3|3|4|5,9",
            "3|3|3|3|3,9"
    })
    @DisplayName("Player choose \"three of a kind\" category and at least three dice have the same value, then scores the sum of these three dice")
    void when_threeOfAKind_then_scores_sum_of_these_dice(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.THREE_OF_A_KIND);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "3|3|5|4|5,0"
    })
    @DisplayName("Player choose \"three of a kind\" category and less than three dice have the same value, then scores 0")
    void when_threeOfAKind_and_less_than_three_dice_with_same_value_then_scores_0(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.THREE_OF_A_KIND);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "3|3|3|3|5,12",
            "5|5|5|5|5,20"
    })
    @DisplayName("Player choose \"four of a kind\" category and at least four dice have the same value, then scores the sum of these four dice")
    void when_fourOfAKind_then_scores_sum_of_these_dice(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.FOUR_OF_A_KIND);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "3|3|5|5|5,0"
    })
    @DisplayName("Player choose \"four of a kind\" category and less than four dice have the same value, then scores 0")
    void when_fourOfAKind_and_less_than_four_dice_with_same_value_then_scores_0(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.FOUR_OF_A_KIND);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "1|2|3|4|5,15"
    })
    @DisplayName("Player choose \"small straight\" category and dice read 1,2,3,4,5, then scores 15")
    void when_smallStraight_with_dice_read_1_2_3_4_5_then_scores_15(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.SMALL_STRAIGHT);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "2|3|4|5|6,0",
            "1|2|4|5|6,0"
    })
    @DisplayName("Player choose \"small straight\" category and dice read not 1,2,3,4,5, then scores 0")
    void when_smallStraight_with_dice_read_not_1_2_3_4_5_then_scores_0(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.SMALL_STRAIGHT);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "2|3|4|5|6,20"
    })
    @DisplayName("Player choose \"large straight\" category and dice read 2,3,4,5,6, then scores 20")
    void when_largeStraight_with_dice_read_2_3_4_5_6_then_scores_20(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.LARGE_STRAIGHT);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "1|2|3|4|5,0",
            "1|2|4|5|6,0"
    })
    @DisplayName("Player choose \"large straight\" category and dice read not 2,3,4,5,6, then scores 0")
    void when_largeStraight_wit_dice_read_not_2_3_4_5_6_then_scores_0(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.LARGE_STRAIGHT);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "6|2|2|2|6,18",
            "6|1|1|1|6,15"
    })
    @DisplayName("Player choose \"full house\" category and dice are two of a kind and three of a kind, then scores sum of all dice")
    void when_fullHouse_with_two_dice_of_a_kind_and_three_dice_of_a_kind_then_scores_sum_of_all_dice(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.FULL_HOUSE);

        assertEquals(expectedScore, actual);
    }

    @ParameterizedTest(name = "Roll '{'{0}'}' scores {1}")
    @CsvSource({
            "2|2|3|3|4,0",
            "6|6|6|6|6,0"
    })
    @DisplayName("Player choose \"full house\" category and dice are not two of a kind and three of a kind, then scores 0")
    void when_fullHouse_without_two_dice_of_a_kind_and_three_dice_of_a_kind_then_scores_0(@ConvertWith(StringToRollArgumentConverter.class) Roll roll, int expectedScore) {
        int actual = yatzy.scoreOfTheRollInACategory(roll, Category.FULL_HOUSE);

        assertEquals(expectedScore, actual);
    }
}
