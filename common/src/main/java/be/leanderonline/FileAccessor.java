package be.leanderonline;

import java.io.File;
import java.util.Scanner;

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

}
