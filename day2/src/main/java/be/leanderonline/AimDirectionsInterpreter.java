package be.leanderonline;

import javafx.util.Pair;

import java.util.List;
import java.util.stream.Collectors;

import static be.leanderonline.Direction.FORWARD;

public class AimDirectionsInterpreter extends AbstractDirectionsInterpreter implements DirectionsInterpreter{

    @Override
    public int getCurrentPosition(List<String> stringList) {
        List<Pair<Direction, Integer>> listOfDirections = convertStringListToListOfDirections(stringList);
        listOfDirections
                .forEach(this::calculateNewCoordinates);
        return super.getCurrentPosition();
    }

    private List<Pair<Direction, Integer>> convertStringListToListOfDirections(List<String> stringList) {
        return stringList.stream()
                .map(this::separateDirectionFromDistance)
                .collect(Collectors.toList());
    }

    private void calculateNewCoordinates(Pair<Direction, Integer> directions) {
        calculateNewAim(directions);
        calculateNewHorizontalPosition(directions);
        calculateNewDepth(directions);
    }

    private void calculateNewAim(Pair<Direction, Integer> directions) {
        switch(directions.getKey()) {
            case DOWN:
                this.setAim(this.getAim() + directions.getValue());
                break;
            case UP:
                this.setAim(this.getAim() - directions.getValue());
                break;
            default:
                break;
        }
    }

    private void calculateNewHorizontalPosition(Pair<Direction, Integer> directions) {
        if (FORWARD.equals(directions.getKey())) {
            this.setHorizontalPosition(this.getHorizontalPosition() + directions.getValue());
        }
    }

    private void calculateNewDepth(Pair<Direction, Integer> directions) {
        if (FORWARD.equals(directions.getKey())) {
            this.setDepth(this.getDepth() + (directions.getValue() * this.getAim()));
        }
    }
}
