package be.leanderonline;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class NaiveDirectionsInterpreter extends AbstractDirectionsInterpreter implements DirectionsInterpreter {

    @Override
    public int getCurrentPosition(List<String> stringList) {
        Map<Direction, Integer> directionIntegerMap = convertStringListToDirectionTotal(stringList);
        this.setHorizontalPosition(getHorizontalPosition(directionIntegerMap));
        this.setDepth(getDepth(directionIntegerMap));
        return super.getCurrentPosition();
    }

    public Map<Direction, Integer> convertStringListToDirectionTotal(List<String> stringList) {
        return stringList.stream()
                .map(this::separateDirectionFromDistance)
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue, Integer::sum));

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
