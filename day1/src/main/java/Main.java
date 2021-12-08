import be.leanderonline.FileAccessor;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileAccessor fileAccessor = new FileAccessor();
        int[] readings = fileAccessor.readAsIntegers(new File("day1/src/main/resources/input.txt"));
        ReadingsInterpreter readingsInterpreter = new ReadingsInterpreter();
        System.out.println("Increased readings:");
        System.out.println(readingsInterpreter.calculateAmountOfHigherReadings(readings));
        System.out.println("Increased readings in 3 reading windows:");
        System.out.println(readingsInterpreter.calculateAmountOfHigherReadingWindows(readings, 3));
    }

}
