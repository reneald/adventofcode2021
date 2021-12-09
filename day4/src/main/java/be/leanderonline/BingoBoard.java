package be.leanderonline;

public interface BingoBoard {

    boolean hasWon();
    int sumOfUnmarkedNumbers();
    void markCell(int row, int column);

}
