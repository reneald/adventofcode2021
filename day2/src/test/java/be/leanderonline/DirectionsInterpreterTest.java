package be.leanderonline;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class DirectionsInterpreterTest {
    private final DirectionsInterpreter directionsInterpreter = new DirectionsInterpreter();

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

}