import bbreant.kata.yatzy.refactoring.Yatzy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyTest {

    @Test
    @DisplayName("Player choose \"chance\" category, then scores is sum of all dice")
    void when_chance_then_scores_sum_of_all_dice() {
        int expected = 16;
        int actual = new Yatzy(3, 3, 4, 5, 1).chance();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Player choose \"yatzy\" category and all dice have same number, then scores is 50")
    void when_yatzy_with_all_dice_having_same_number_then_scores_50() {
        int expected = 50;
        int actual = new Yatzy(4, 4, 4, 4, 4).yatzy();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Player choose \"yatzy\" category and all dice have not same number, then scores is 0")
    void when_yatzy_with_all_dice_having_not_same_number_then_scores_0() {
        int expected = 0;
        assertEquals(expected, new Yatzy(6, 6, 6, 6, 3).yatzy());
    }

    @Test
    @DisplayName("Player choose \"ones\" category, then scores is the sum of ones")
    void when_onces_then_scores_sum_of_ones() {
        assertEquals(1, new Yatzy(1, 2, 3, 4, 5).ones());
        assertEquals(2, new Yatzy(1, 2, 1, 4, 5).ones());
        assertEquals(0, new Yatzy(6, 2, 2, 4, 5).ones());
        assertEquals(4, new Yatzy(1, 2, 1, 1, 1).ones());
    }

    @Test
    @DisplayName("Player choose \"twos\" category, then scores is the sum of twos")
    void when_twos_then_scores_sum_of_twos() {
        assertEquals(4, new Yatzy(1, 2, 3, 2, 6).twos());
        assertEquals(10, new Yatzy(2, 2, 2, 2, 2).twos());
    }

    @Test
    @DisplayName("Player choose \"threes\" category, then scores is the sum of threes")
    void when_threes_then_scores_sum_of_threes() {
        assertEquals(6, new Yatzy(1, 2, 3, 2, 3).threes());
        assertEquals(12, new Yatzy(2, 3, 3, 3, 3).threes());
    }

    @Test
    @DisplayName("Player choose \"fours\" category, then scores is the sum of fours")
    void when_fours_then_scores_sum_of_fours() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
    }

    @Test
    @DisplayName("Player choose \"fives\" category, then scores is the sum of fives")
    void when_fives_then_scores_sum_of_fives() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
    }

    @Test
    @DisplayName("Player choose \"sixes\" category, then scores is the sum of sixes")
    void when_sixes_then_scores_sum_of_sixes() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }

    @Test
    @DisplayName("Player choose \"pair\" category but no pair in roll, then scores is 0")
    void when_pair_with_less_than_one_pair_then_scores_0() {
        assertEquals(0, new Yatzy(1, 2, 3, 4, 5).pair());
    }

    @Test
    @DisplayName("Player choose \"pair\" category and one pair in roll, then scores is the sum of two matching dice")
    void when_pair_with_one_pair_then_scores_sum_of_two_matching_dice() {
        assertEquals(6, new Yatzy(3, 4, 3, 5, 6).pair());
        assertEquals(6, new Yatzy(5, 3, 3, 3, 4).pair());
        assertEquals(6, new Yatzy(5, 3, 3, 3, 3).pair());
        assertEquals(12, new Yatzy(5, 3, 6, 6, 5).pair());
    }

    @Test
    @DisplayName("Player choose \"pair\" category and multiple pair in roll, then scores is the sum of two highest matching dice")
    void when_pair_with_more_than_one_pair_then_scores_sum_of_two_highest_matching_dice() {
        assertEquals(10, new Yatzy(5, 3, 3, 3, 5).pair());
        assertEquals(10, new Yatzy(5, 5, 3, 3, 5).pair());
        assertEquals(12, new Yatzy(5, 3, 6, 6, 5).pair());
    }

    @Test
    @DisplayName("Player choose \"two pairs\" category and less than two pairs in roll, then scores is 0")
    void when_twoPair_with_less_than_two_pair_then_scores_0() {
        assertEquals(0, new Yatzy(1, 1, 2, 3, 4).twoPair());
        assertEquals(0, new Yatzy(1, 1, 1, 3, 4).twoPair());
        assertEquals(0, new Yatzy(1, 1, 1, 1, 4).twoPair());
    }

    @Test
    @DisplayName("Player choose \"two pairs\" category and two pairs in roll, then scores is the sum of these dice")
    void when_twoPair_with_two_pair_then_scores_sum_of_these_dice() {
        assertEquals(16, new Yatzy(3, 3, 5, 4, 5).twoPair());
        assertEquals(16, new Yatzy(3, 3, 5, 5, 5).twoPair());
    }

    @Test
    @DisplayName("Player choose \"three of a kind\" category and at least three dice have the same value, then scores is the sum of these three dice")
    void when_threeOfAKind_then_scores_sum_of_these_dice() {
        assertEquals(9, new Yatzy(3, 3, 3, 4, 5).threeOfAKind());
        assertEquals(15, new Yatzy(5, 3, 5, 4, 5).threeOfAKind());
        assertEquals(9, new Yatzy(3, 3, 3, 3, 5).threeOfAKind());
        assertEquals(0, new Yatzy(3, 3, 4, 5, 5).threeOfAKind());
    }

    @Test
    @DisplayName("Player choose \"three of a kind\" category and less than three dice have the same value, then scores is 0")
    void when_threeOfAKind_and_less_than_three_dice_with_same_value_then_scores_0() {
        assertEquals(0, new Yatzy(3, 3, 4, 5, 5).threeOfAKind());
    }

    @Test
    @DisplayName("Player choose \"four of a kind\" category and at least four dice have the same value, then scores is the sum of these four dice")
    void when_fourOfAKind_then_scores_sum_of_these_dice() {
        assertEquals(12, new Yatzy(3, 3, 3, 3, 5).fourOfAKind());
        assertEquals(20, new Yatzy(5, 5, 5, 4, 5).fourOfAKind());
        assertEquals(12, new Yatzy(3, 3, 3, 3, 3).fourOfAKind());
    }

    @Test
    @DisplayName("Player choose \"four of a kind\" category and less than four dice have the same value, then scores is 0")
    void when_fourOfAKind_and_less_than_four_dice_with_same_value_then_scores_0() {
        assertEquals(0, new Yatzy(3, 3, 3, 5, 5).fourOfAKind());
    }

    @Test
    @DisplayName("Player choose \"small straight\" category and dice read 1,2,3,4,5, then scores is 15")
    void when_smallStraight_with_dice_read_1_2_3_4_5_then_scores_15() {
        assertEquals(15, new Yatzy(1, 3, 2, 4, 5).smallStraight());
    }

    @Test
    @DisplayName("Player choose \"small straight\" category and dice read not 1,2,3,4,5, then scores is 0")
    void when_smallStraight_with_dice_read_not_1_2_3_4_5_then_scores_0() {
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).smallStraight());
    }

    @Test
    @DisplayName("Player choose \"large straight\" category and dice read 2,3,4,5,6, then scores is 20")
    void when_largeStraight_with_dice_read_2_3_4_5_6_then_scores_20() {
        assertEquals(20, new Yatzy(2, 4, 3, 5, 6).largeStraight());
    }

    @Test
    @DisplayName("Player choose \"large straight\" category and dice read not 2,3,4,5,6, then scores is 0")
    void when_largeStraight_wit_dice_read_not_2_3_4_5_6_then_scores_0() {
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).largeStraight());
    }

    @Test
    @DisplayName("Player choose \"full house\" category and dice are two of a kind and three of a kind, then scores is sum of all dice")
    void when_fullHouse_with_two_dice_of_a_kind_and_three_dice_of_a_kind_then_scores_sum_of_all_dice() {
        assertEquals(18, new Yatzy(6, 2, 2, 2, 6).fullHouse());
    }

    @Test
    @DisplayName("Player choose \"full house\" category and dice are not two of a kind and three of a kind, then scores is 0")
    void when_fullHouse_without_two_dice_of_a_kind_and_three_dice_of_a_kind_then_scores_0() {
        assertEquals(0, new Yatzy(2, 3, 4, 5, 6).fullHouse());
        assertEquals(0, new Yatzy(6, 6, 6, 6, 6).fullHouse());
    }
}
