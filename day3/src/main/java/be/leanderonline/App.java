package be.leanderonline;

import java.io.File;
import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FileAccessor fileAccessor = new FileAccessor();
        Optional<List<String>> strings = fileAccessor.readAsStringList(new File("day3/src/main/resources/input.txt"));
        DiagnosticsInterpreter diagnosticsInterpreter = new NaiveDiagnosticsInterpreter(strings.orElseThrow(() -> new IllegalArgumentException("Input is empty!")));
        System.out.println("Gamma Rate:");
        System.out.println(diagnosticsInterpreter.getGammaRate());
        System.out.println("Epsilon Rate:");
        System.out.println(diagnosticsInterpreter.getEpsilonRate());
        System.out.println("Power Consumption:");
        System.out.println(diagnosticsInterpreter.getPowerConsumption());
        System.out.println("Oxygen Generator rating:");
        System.out.println(diagnosticsInterpreter.getOxygenGeneratorRating());
        System.out.println("CO2 scrubber rating:");
        System.out.println(diagnosticsInterpreter.getCo2ScrubberRating());
        System.out.println("Life support rating:");
        System.out.println(diagnosticsInterpreter.getLifeSupportRating());
    }
}
