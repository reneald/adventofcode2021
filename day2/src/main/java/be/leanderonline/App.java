package be.leanderonline;

import java.io.File;
import java.util.List;
import java.util.Map;
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
        Optional<List<String>> strings = fileAccessor.readAsStringList(new File("day2/src/main/resources/input.txt"));
        DirectionsInterpreter directionsInterpreter = new DirectionsInterpreter();
        Map<Direction, Integer> directionIntegerMap = directionsInterpreter.convertStringListToDirectionTotal(strings.orElseThrow(() -> new IllegalArgumentException("could not get directions from input.")));
        int horizontalPositionMultipliedByDepth = directionsInterpreter.getHorizontalPositionMultipliedByDepth(directionIntegerMap);
        System.out.println(horizontalPositionMultipliedByDepth);
    }


}
