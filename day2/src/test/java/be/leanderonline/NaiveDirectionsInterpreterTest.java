package be.leanderonline;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class NaiveDirectionsInterpreterTest {
    private final NaiveDirectionsInterpreter directionsInterpreter = new NaiveDirectionsInterpreter();

    @Test
    public void convertStringListToDirectionTotal_happyFlow() {
        //GIVEN
        List<String> input = Arrays.asList(
                "forward 7",
                "forward 9",
                "forward 9",
                "down 3",
                "down 8",
                "down 3",
                "forward 6",
                "down 7",
                "up 3");

        //WHEN
        Map<Direction, Integer> result = directionsInterpreter.convertStringListToDirectionTotal(input);

        //THEN
        assertThat(result).isNotEmpty();
        assertThat(result).containsKeys(Direction.FORWARD, Direction.DOWN, Direction.UP);
        assertThat(result.get(Direction.FORWARD)).isEqualTo(31);
        assertThat(result.get(Direction.DOWN)).isEqualTo(21);
        assertThat(result.get(Direction.UP)).isEqualTo(3);
    }

    @Test
    public void getHorizontalPositionMultipliedByDepth() {
        //GIVEN
        Map<Direction, Integer> directions = new HashMap<>();
        directions.put(Direction.DOWN, 21);
        directions.put(Direction.UP, 3);
        directions.put(Direction.FORWARD,31);

        //WHEN
        int result = directionsInterpreter.getHorizontalPositionMultipliedByDepth(directions);

        //THEN
        assertThat(result).isEqualTo(558);
    }

}