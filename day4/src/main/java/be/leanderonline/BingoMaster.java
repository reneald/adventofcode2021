package be.leanderonline;

import javafx.util.Pair;

import java.util.List;

public interface BingoMaster {
    List<Integer> getDrawLine();
    int getAmountOfBoards();
    Pair<Integer, BingoBoard> play() throws BingoException;
    Pair<Integer, BingoBoard> playUntilAllBoardsWin() throws BingoException;
}
