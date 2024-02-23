import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void when_chance_then_scores_sum_of_all_dice() {
        int expected = 16;
        int actual = new Yatzy(3,3,4,5,1).chance();

        assertEquals(expected, actual);
    }

    @Test
    public void when_yatzy_with_all_dice_having_same_number_then_scores_50() {
        int expected = 50;
        int actual = new Yatzy(4,4,4,4,4).yatzy();

        assertEquals(expected, actual);
    }

    @Test
    public void when_yatzy_with_all_dice_having_not_same_number_then_scores_0() {
        int expected = 0;
        assertEquals(expected, new Yatzy(6,6,6,6,3).yatzy());
    }

    @Test public void when_onces_then_scores_sum_of_one() {
        assertEquals(1, new Yatzy(1,2,3,4,5).ones());
        assertEquals(2, new Yatzy(1,2,1,4,5).ones());
        assertEquals(0, new Yatzy(6,2,2,4,5).ones());
        assertEquals(4, new Yatzy(1,2,1,1,1).ones());
    }

    @Test
    public void when_twos_then_scores_sum_of_two() {
        assertEquals(4, new Yatzy(1,2,3,2,6).twos());
        assertEquals(10, new Yatzy(2,2,2,2,2).twos());
    }

    @Test
    public void when_threes_then_scores_sum_of_three() {
        assertEquals(6, new Yatzy(1,2,3,2,3).threes());
        assertEquals(12, new Yatzy(2,3,3,3,3).threes());
    }

    @Test
    public void when_fours_then_scores_sum_of_four()
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    public void when_fives_then_scores_sum_of_five() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    public void when_sixes_then_scores_sum_of_six() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void when_pair_with_less_than_one_pair_then_scores_0() {
        assertEquals(0, new Yatzy(1,2,3,4,5).pair());
    }

    @Test
    public void when_pair_with_more_than_one_pair_then_scores_sum_of_two_highest_matching_dice() {
        assertEquals(6, new Yatzy(3,4,3,5,6).pair());
        assertEquals(10, new Yatzy(5,3,3,3,5).pair());
        assertEquals(6, new Yatzy(5,3,3,3,4).pair());
        assertEquals(6, new Yatzy(5,3,3,3,3).pair());
        assertEquals(12, new Yatzy(5,3,6,6,5).pair());
    }

    @Test
    public void when_twoPair_with_less_than_two_pair_then_scores_0() {
        assertEquals(0, new Yatzy(1,1,2,3,4).twoPair());
        assertEquals(0, new Yatzy(1,1,1,3,4).twoPair());
    }

    @Test
    public void when_twoPair_with_two_pair_then_scores_sum_of_these_dice() {
        assertEquals(16, new Yatzy(3,3,5,4,5).twoPair());
        assertEquals(16, new Yatzy(3,3,5,5,5).twoPair());
    }

    @Test
    public void when_threeOfAKind_then_scores_sum_of_these_dice()
    {
        assertEquals(9, new Yatzy(3,3,3,4,5).threeOfAKind());
        assertEquals(15, new Yatzy(5,3,5,4,5).threeOfAKind());
        assertEquals(9, new Yatzy(3,3,3,3,5).threeOfAKind());
        assertEquals(0, new Yatzy(3,3,4,5,5).threeOfAKind());
    }

    @Test
    public void when_fourOfAKind_then_scores_sum_of_these_dice() {
        assertEquals(12, new Yatzy(3,3,3,3,5).fourOfAKind());
        assertEquals(20, new Yatzy(5,5,5,4,5).fourOfAKind());
        assertEquals(12, new Yatzy(3,3,3,3,3).fourOfAKind());
        assertEquals(0, new Yatzy(3,3,3,5,5).fourOfAKind());
    }

    @Test
    public void when_smallStraight_with_dice_read_1_2_3_4_5_then_scores_15() {
        assertEquals(15, new Yatzy(1,2,3,4,5).smallStraight());
        assertEquals(15, new Yatzy(2,3,4,5,1).smallStraight());
    }

    @Test
    public void when_smallStraight_with_dice_read_not_1_2_3_4_5_then_scores_0() {
        assertEquals(0, new Yatzy(1,2,2,4,5).smallStraight());
    }

    @Test
    public void when_largeStraight_with_dice_read_1_2_3_4_5_6_then_scores_20() {
        assertEquals(20, new Yatzy(6,2,3,4,5).largeStraight());
        assertEquals(20, new Yatzy(2,3,4,5,6).largeStraight());
    }

    @Test
    public void when_largeStraight_wit_dice_read_not_1_2_3_4_5_6_then_scores_0() {
        assertEquals(0, new Yatzy(1,2,2,4,5).largeStraight());
    }

    @Test
    public void when_fullHouse_with_two_dice_of_a_kind_and_three_dice_of_a_kind_then_scores_sum_of_all_dice() {
        assertEquals(18, new Yatzy(6,2,2,2,6).fullHouse());
    }

    @Test
    public void when_fullHouse_without_two_dice_of_a_kind_and_three_dice_of_a_kind_then_scores_0() {
        assertEquals(0, new Yatzy(2,3,4,5,6).fullHouse());
        assertEquals(0, new Yatzy(6,6,6,6,6).fullHouse());
    }
}
