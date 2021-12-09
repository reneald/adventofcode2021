package be.leanderonline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BingoInterpreter {

    public FirstBingoMaster createBingo(List<String> input) {
        List<Integer> drawLine = getDrawLine(input);
        List<BingoBoard> bingoBoards = getBingoBoards(input);
        return new FirstBingoMaster(drawLine, bingoBoards);
    }

    private List<BingoBoard> getBingoBoards(List<String> input) {
        List<BingoBoard> bingoBoards = new ArrayList<>();
        int index = 2;
        int boardSize = getBoardSize(input, index);
        while (index < input.size()) {
            List<List<Integer>> elements = new ArrayList<>();
            for (int i = 0; i < boardSize; i++) {
                String rowOfNumbers = input.get(index + i).trim();
                elements.add(Arrays.stream(rowOfNumbers.split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toList()));
            }
            BingoBoardImpl board = new BingoBoardImpl(elements);
            bingoBoards.add(board);
            index += boardSize + 1;
        }
        return bingoBoards;
    }

    private int getBoardSize(List<String> input, int index) {
        long count = Arrays.stream(input.get(index).trim().split("\\s+")).map(Integer::parseInt).count();
        return (int) count;
    }

    private List<Integer> getDrawLine(List<String> input) {
        String[] separateNumberStrings = input.get(0).split(",");
        return Arrays.stream(separateNumberStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
