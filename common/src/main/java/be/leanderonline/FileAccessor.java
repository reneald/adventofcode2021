package be.leanderonline;

import java.io.*;
import java.util.*;

import static be.leanderonline.Direction.FORWARD;

public class FileAccessor {

    public int[] readAsIntegers(File file) {
        int[] ints = new int[2000];
        try (Scanner scanner = new Scanner(file)) {
            int i = 0;
            while (scanner.hasNextInt()) {
                ints[i++] = scanner.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ints;
    }

    public Map<Direction, Integer> readAsDirectionTotals(File file) {
        Map<Direction, Integer> directions = new HashMap<>();
        try (BufferedReader reader = getBufferedReader(file)) {
            String directionStringFromLine;
            while ((directionStringFromLine = reader.readLine()) != null) {
                String[] s = directionStringFromLine.split(" ");
                Direction directionFromLine = null;
                Integer distance = Integer.parseInt(s[1]);
                for (Direction direction : Direction.values()) {
                    if (direction.getMessage().equals(s[0])) {
                        directionFromLine = direction;
                    }
                }
                if (directionFromLine == null) {
                    throw new IllegalArgumentException("Given direction is not known.");
                }
                directions.merge(directionFromLine, distance, Integer::sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return directions;
    }

    private BufferedReader getBufferedReader(File file) throws FileNotFoundException {
        FileReader fileReader = new FileReader(file);
        return new BufferedReader(fileReader);
    }

}
