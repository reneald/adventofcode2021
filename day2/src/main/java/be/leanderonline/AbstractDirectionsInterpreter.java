package be.leanderonline;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Optional;

public abstract class AbstractDirectionsInterpreter {
    private int horizontalPosition = 0;
    private int depth = 0;
    private int aim = 0;

    public int getCurrentPosition () {
        return horizontalPosition * depth;
    }

    protected int getHorizontalPosition() {
        return horizontalPosition;
    }

    protected void setHorizontalPosition(int horizontalPosition) {
        this.horizontalPosition = horizontalPosition;
    }

    protected int getDepth() {
        return depth;
    }

    protected void setDepth(int depth) {
        this.depth = depth;
    }

    protected int getAim() {
        return aim;
    }

    protected void setAim(int aim) {
        this.aim = aim;
    }

    protected Pair<Direction, Integer> separateDirectionFromDistance(String string) {
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
}
