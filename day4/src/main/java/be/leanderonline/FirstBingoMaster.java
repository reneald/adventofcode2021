package be.leanderonline;

import javafx.util.Pair;

import java.util.List;
import java.util.Optional;

public class FirstBingoMaster implements BingoMaster {
    private List<Integer> drawLine;
    private List<BingoBoard> boards;
    private int drawLineIndex;

    public FirstBingoMaster(List<Integer> drawLine, List<BingoBoard> boards) {
        this.drawLine = drawLine;
        this.boards = boards;
        this.drawLineIndex = 0;
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
    public Pair<Integer, BingoBoard> play() throws BingoException {
        drawLineIndex -= 1;
        do {
            drawLineIndex++;
            Integer currentNumber = getNumberThatWasJustCalled();
            boards.forEach(board -> board.markNumber(currentNumber));
        } while (!anyBoardHasWon());
        return new Pair<>(getNumberThatWasJustCalled(), getWinner());
    }

    private Integer getNumberThatWasJustCalled() {
        return drawLine.get(drawLineIndex);
    }

    private boolean anyBoardHasWon() {
        return this.boards.stream()
                .anyMatch(BingoBoard::hasWon);
    }

    private BingoBoard getWinner() throws BingoException {
        Optional<BingoBoard> optionalWinner = this.boards.parallelStream()
                .filter(BingoBoard::hasWon)
                .findFirst();
        return optionalWinner.orElseThrow(() -> new BingoException("No Board has won after playing"));
    }
}
