import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class Yatzy {

    private final List<Integer> diceList;
    private final Map<Integer, Long> countOfDiceValue;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
        this.diceList = Arrays.stream(dice).boxed().collect(Collectors.toList());
        this.countOfDiceValue = diceList.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));

    }


    public int twoPair() {
        List<Integer> diceValuesWithPair = this.countOfDiceValue.entrySet().stream().filter(x -> x.getValue() >= 2).map(Entry<Integer, Long>::getKey).collect(Collectors.toList());

        if(diceValuesWithPair.size() >= 2) {
            return diceValuesWithPair.stream().reduce(Integer::sum).map(integer -> integer*2).orElse(0);
        } else {
            return 0;
        }
    }

    public int fourOfAKind() {
        Optional<Integer> fourOfaKindValue = this.countOfDiceValue.entrySet().stream().filter(x -> x.getValue() >= 4).map(Entry<Integer, Long>::getKey).reduce(Integer::max);
        return fourOfaKindValue.map(integer -> integer * 4).orElse(0);
    }

    public int threeOfAKind() {
        Optional<Integer> threeOfaKindValue = this.countOfDiceValue.entrySet().stream().filter(x -> x.getValue() >= 3).map(Entry<Integer, Long>::getKey).reduce(Integer::max);
        return threeOfaKindValue.map(integer -> integer * 3).orElse(0);
    }

    public int smallStraight() {
        if(this.countOfDiceValue.size() >= 5 && !this.countOfDiceValue.containsKey(6)){
            return 15;
        } else return 0;
    }

    public int largeStraight() {
        if(this.countOfDiceValue.size() >= 5 && !this.countOfDiceValue.containsKey(1)){
            return 20;
        } else return 0;
    }

    public int fullHouse() {
        if(this.countOfDiceValue.size() == 2){
            return this.diceList.stream().reduce(0, Integer::sum);
        } else return 0;
    }

    public int pair() {
        Optional<Integer> pairWithHighestValue = this.countOfDiceValue.entrySet().stream().filter(x -> x.getValue() >= 2).map(Entry<Integer, Long>::getKey).reduce(Integer::max);
        return pairWithHighestValue.map(integer -> integer * 2).orElse(0);
    }

    public int chance() {
        return this.diceList.stream().reduce(0, Integer::sum);
    }

    public int yatzy() {
        if (this.diceList.stream().distinct().count() == 1) {
            return 50;
        } else return 0;
    }

    public int ones() {
        return this.categoryNumbers(1);
    }

    public int twos() {
        return this.categoryNumbers(2);
    }

    public int threes() {
        return this.categoryNumbers(3);
    }

    public int fours() {
        return this.categoryNumbers(4);
    }

    public int fives() {
        return this.categoryNumbers(5);
    }

    public int sixes() {
        return this.categoryNumbers(6);
    }

    private int categoryNumbers(int numberOfCategory) {
        return this.diceList.stream().filter(d -> d == numberOfCategory).reduce(0, Integer::sum);
    }
}



