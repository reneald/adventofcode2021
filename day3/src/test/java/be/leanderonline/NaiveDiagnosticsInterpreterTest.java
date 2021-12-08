package be.leanderonline;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class NaiveDiagnosticsInterpreterTest {
    @Test
    public void getGammaRate_happyFlow() {
        //GIVEN
        List<String> input = Arrays.asList(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010"
        );
        NaiveDiagnosticsInterpreter diagnosticsInterpreter = new NaiveDiagnosticsInterpreter(input);

        //WHEN
        int result = diagnosticsInterpreter.getGammaRate();

        //THEN
        Assertions.assertThat(result).isEqualTo(22);
    }

    @Test
    public void getEpsilonRate_happyFlow() {
        //GIVEN
        List<String> input = Arrays.asList(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010"
        );
        NaiveDiagnosticsInterpreter diagnosticsInterpreter = new NaiveDiagnosticsInterpreter(input);

        //WHEN
        int result = diagnosticsInterpreter.getEpsilonRate();

        //THEN
        Assertions.assertThat(result).isEqualTo(9);
    }

    @Test
    public void getPowerConsumption_happyFlow() {
        //GIVEN
        List<String> input = Arrays.asList(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010"
        );
        NaiveDiagnosticsInterpreter diagnosticsInterpreter = new NaiveDiagnosticsInterpreter(input);

        //WHEN
        int result = diagnosticsInterpreter.getPowerConsumption();

        //THEN
        Assertions.assertThat(result).isEqualTo(198);
    }

    @Test
    public void getOxygenGeneratorRating_happyFlow() {
        //GIVEN
        List<String> input = Arrays.asList(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010"
        );
        NaiveDiagnosticsInterpreter diagnosticsInterpreter = new NaiveDiagnosticsInterpreter(input);

        //WHEN
        int result = diagnosticsInterpreter.getOxygenGeneratorRating();

        //THEN
        Assertions.assertThat(result).isEqualTo(23);
    }

    @Test
    public void getCo2ScrubberRating_happyFlow() {
        //GIVEN
        List<String> input = Arrays.asList(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010"
        );
        NaiveDiagnosticsInterpreter diagnosticsInterpreter = new NaiveDiagnosticsInterpreter(input);

        //WHEN
        int result = diagnosticsInterpreter.getCo2ScrubberRating();

        //THEN
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    public void getLifeSupportRating_happyFlow() {
        //GIVEN
        List<String> input = Arrays.asList(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010"
        );
        NaiveDiagnosticsInterpreter diagnosticsInterpreter = new NaiveDiagnosticsInterpreter(input);

        //WHEN
        int result = diagnosticsInterpreter.getLifeSupportRating();

        //THEN
        Assertions.assertThat(result).isEqualTo(230);
    }

}