package be.leanderonline;

import java.util.Arrays;
import java.util.List;

public class BingoMaster {
    private List<Integer> drawLine;
    private List<BingoBoard> boards;

    public BingoMaster(List<Integer> drawLine, List<BingoBoard> boards) {
        this.drawLine = drawLine;
        this.boards = boards;
    }

    public List<Integer> getDrawLine() {
        return drawLine;
    }

    public int getAmountOfBoards() {
        return boards.size();
    }
}
