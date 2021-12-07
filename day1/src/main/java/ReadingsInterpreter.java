import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadingsInterpreter {

    public int calculateAmountOfHigherReadings(int[] readings) {
        int amount = 0;
        int previousReading = readings[0];
        for (int reading : readings) {
            amount += oneWhenCurrentIsLarger(previousReading, reading);
            previousReading = replacePreviousWithCurrentWindowSum(reading);
        }
        return amount;
    }

    private int oneWhenCurrentIsLarger(int previousReading, int reading) {
        return reading > previousReading ? 1 : 0;
    }

    public int calculateAmountOfHigherReadingWindows(int[] readings, int windowSize) {
        if (readings.length <= windowSize * 2) {
            throw new IllegalArgumentException("Not enough readings to compare at least 2 windows of size " + windowSize);
        }
        int amount = 0;
        List<Integer> readingsList = getReadingsList(readings);
        int previousWindowSum = calculateWindowTotal(readingsList, windowSize);
        readingsList.remove(0);
        while (readingsList.size() >= windowSize) {
            int currentWindowSum = calculateWindowTotal(readingsList, windowSize);
            amount += oneWhenCurrentIsLarger(previousWindowSum, currentWindowSum);
            readingsList.remove(0);
            previousWindowSum = replacePreviousWithCurrentWindowSum(currentWindowSum);
        }
        return amount;
    }

    private int replacePreviousWithCurrentWindowSum(int currentWindowSum) {
        int previousWindowSum;
        previousWindowSum = currentWindowSum;
        return previousWindowSum;
    }

    private List<Integer> getReadingsList(int[] readings) {
        return Arrays.stream(readings).boxed().collect(Collectors.toList());
    }

    private int calculateWindowTotal(List<Integer> readings, int windowSize) {
        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += readings.get(i);
        }
        return sum;
    }

}
