package be.leanderonline;

import java.util.List;

public class BingoBoardImpl implements BingoBoard{
    private BingoCell[][] board;

    private BingoBoardImpl(BingoBoardBuilder builder) {
        this.board = builder.board;
    }

    public BingoBoardImpl(List<List<Integer>> elements) {
        this.board = new BingoCell[elements.size()][elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            for (int j = 0; j < elements.size(); j++) {
                BingoCell cell = new BingoCell(elements.get(i).get(j));
                this.board[i][j] = cell;
            }
        }
    }

    @Override
    public boolean hasWon() {
        return false;
    }

    @Override
    public int sumOfUnmarkedNumbers() {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!board[i][j].isMarked()) {
                    sum += board[i][j].getNumber();
                }
            }
        }
        return sum;
    }

    @Override
    public void markCell(int row, int column) {
        BingoCell cellToMark = this.board[row][column];
        cellToMark.setMarked(true);
    }

    public static class BingoBoardBuilder {
        private BingoCell[][] board;

        public BingoBoardBuilder(int size) {
            this.board = new BingoCell[size][size];
        }

        public BingoBoardBuilder withRow(int rowNumber, int ...elements) {
            if (rowNumber >= this.board[0].length) {
                throw new IllegalArgumentException("Row does not exist.");
            }
            if (elements.length > this.board[0].length) {
                throw new IllegalArgumentException(elements.length + " elements given while board size is" + this.board[0].length);
            }
            for (int i = 0; i < elements.length; i++) {
                BingoCell cell = new BingoCell(elements[i]);
                this.board[rowNumber][i] = cell;
            }
            return this;
        }

        public BingoBoardImpl build() {
            return new BingoBoardImpl(this);
        }
    }
}
