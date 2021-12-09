package be.leanderonline;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;

public class FirstBingoMaster implements BingoMaster {
    private List<Integer> drawLine;
    private List<BingoBoard> boards;

    public FirstBingoMaster(List<Integer> drawLine, List<BingoBoard> boards) {
        this.drawLine = drawLine;
        this.boards = boards;
    }

    @Override
    public List<Integer> getDrawLine() {
        return drawLine;
    }

    @Override
    public int getAmountOfBoards() {
        return boards.size();
    }

    @Override
    public Pair<Integer, BingoBoard> play() {
        return null;
    }
}
