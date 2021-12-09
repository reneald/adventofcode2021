package be.leanderonline;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BingoBoardImpl implements BingoBoard {
    private final BingoCell[][] board;

    private BingoBoardImpl(BingoBoardBuilder builder) {
        this.board = builder.board;
    }

    public BingoBoardImpl(List<List<Integer>> elements) {
        this.board = new BingoCell[elements.size()][elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            for (int j = 0; j < elements.size(); j++) {
                BingoCell cell = new BingoCell(elements.get(i).get(j), i, j);
                this.board[i][j] = cell;
            }
        }
    }

    @Override
    public boolean hasWon() {
        List<BingoCell> markedCells = Arrays.stream(this.board)
                .flatMap(Arrays::stream)
                .filter(BingoCell::isMarked)
                .collect(Collectors.toList());
        for (BingoCell cell : markedCells) {
            if (allCellsOfThisColumnAreMarked(cell.getColumnIndex(), markedCells) ||
                    allCellsOfThisRowAreMarked(cell.getRowIndex(), markedCells)) {
                return true;
            }
        }
        return false;
    }

    private boolean allCellsOfThisColumnAreMarked(int column, List<BingoCell> markedCells) {
        return markedCells.stream()
                .filter(cell -> cell.getColumnIndex() == column)
                .count() == board.length;
    }

    private boolean allCellsOfThisRowAreMarked(int row, List<BingoCell> markedCells) {
        return markedCells.stream()
                .filter(cell -> cell.getRowIndex() == row)
                .count() == board.length;
    }

    private boolean isColumnFullyMarked(int column) {
        for (BingoCell[] row : board) {
            if (!row[column].isMarked()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int sumOfUnmarkedNumbers() {
        int sum = 0;
        for (BingoCell[] bingoCells : board) {
            for (int i = 0; i < board.length; i++) {
                if (!bingoCells[i].isMarked()) {
                    sum += bingoCells[i].getNumber();
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

    @Override
    public void markNumber(int number) {
        Arrays.stream(this.board)
                .forEach(row -> Arrays.stream(row)
                        .forEach(cell -> markIfSameNumber(number, cell)));
    }

    private void markIfSameNumber(int number, BingoCell cell) {
        cell.setMarked(number == cell.getNumber());
    }

    public static class BingoBoardBuilder {
        private final BingoCell[][] board;

        public BingoBoardBuilder(int size) {
            this.board = new BingoCell[size][size];
        }

        public BingoBoardBuilder withRow(int rowNumber, int... elements) {
            if (rowNumber >= this.board[0].length) {
                throw new IllegalArgumentException("Row does not exist.");
            }
            if (elements.length > this.board[0].length) {
                throw new IllegalArgumentException(elements.length + " elements given while board size is" + this.board[0].length);
            }
            for (int i = 0; i < elements.length; i++) {
                BingoCell cell = new BingoCell(elements[i], rowNumber, i);
                this.board[rowNumber][i] = cell;
            }
            return this;
        }

        public BingoBoardImpl build() {
            return new BingoBoardImpl(this);
        }
    }
}
