package be.leanderonline;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AimDirectionsInterpreterTest {

    private final AimDirectionsInterpreter directionsInterpreter = new AimDirectionsInterpreter();

    @Test
    public void getCurrentPosition_happyFlow() {
        //GIVEN
        List<String> input = Arrays.asList(
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2");

        //WHEN
        int result = directionsInterpreter.getCurrentPosition(input);

        //THEN
        assertThat(result).isEqualTo(900);
    }

}