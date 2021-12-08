package be.leanderonline;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class DirectionsInterpreter {
    public Map<Direction, Integer> convertStringListToDirectionTotal(List<String> stringList) {
        return stringList.stream()
                .map(this::separateDirectionFromDistance)
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue, Integer::sum));

    }

    private Pair<Direction, Integer> separateDirectionFromDistance(String string) {
        String separator = " ";
        String[] strings = string.split(separator);
        verifyStringLength(strings);
        Direction directionToReturn = getDirectionFromString(strings[0]);
            String distanceString = strings[1];
        int distanceToReturn = getDistanceFromString(distanceString);

        return new Pair<>(directionToReturn, distanceToReturn);
    }

    private int getDistanceFromString(String distanceString) {
        int distance;
        try {
            distance = Integer.parseInt(distanceString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Direction could not be interpreted as an amount.");
        }
        return distance;
    }

    private Direction getDirectionFromString(String string) {
        Optional<Direction> result = Arrays.stream(Direction.values())
                .filter(direction -> direction.getMessage().equals(string))
                .findFirst();
        return result.orElseThrow(() -> new IllegalArgumentException("Unknown direction."));
    }

    private void verifyStringLength(String[] strings) {
        if (strings.length != 2) {
            throw new IllegalArgumentException("wrong input length.");
        }
    }

    public int getHorizontalPositionMultipliedByDepth(Map<Direction, Integer> directions) {
        int depth = getDepth(directions);
        Integer horizontalPosition = getHorizontalPosition(directions);
        return horizontalPosition * depth;
    }

    private Integer getHorizontalPosition(Map<Direction, Integer> directions) {
        return directions.get(Direction.FORWARD);
    }

    private int getDepth(Map<Direction, Integer> directions) {
        return directions.get(Direction.DOWN) - directions.get(Direction.UP);
    }

}
