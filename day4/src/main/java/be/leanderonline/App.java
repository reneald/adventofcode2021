package be.leanderonline;

import javafx.util.Pair;

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
        Optional<List<String>> strings = fileAccessor.readAsStringList(new File("day4/src/main/resources/input.txt"));
        FirstBingoMaster bingo = new BingoInterpreter().createBingo(strings.orElseThrow(() -> new IllegalArgumentException("Input is empty")));
        try {
            Pair<Integer, BingoBoard> result = bingo.play();
            System.out.println(result.getKey() * result.getValue().sumOfUnmarkedNumbers());
        } catch (BingoException e) {
            e.printStackTrace();
        }

    }
}
