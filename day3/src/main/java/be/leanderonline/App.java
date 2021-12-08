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
        //TODO only need to count the total of lines and then count the 1s for each column, no need to count the 0s as well
        //example for binary to decimal
        String binaryString="1010";
        int decimal=Integer.parseInt(binaryString,2);
        System.out.println( "Hello World!" );
    }
}
