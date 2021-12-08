package be.leanderonline;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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

    public Optional<List<String>> readAsStringList(File file) {
        List<String> stringList = null;
        try (BufferedReader reader = getBufferedReader(file)) {
            stringList = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(stringList);
    }

    private BufferedReader getBufferedReader(File file) throws FileNotFoundException {
        FileReader fileReader = new FileReader(file);
        return new BufferedReader(fileReader);
    }

}
