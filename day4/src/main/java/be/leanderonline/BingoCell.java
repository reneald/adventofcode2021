package be.leanderonline;

public class BingoCell {
    private boolean marked;
    private final int number;
    private final int rowIndex;
    private final int columnIndex;

    public BingoCell(int number, int rowIndex, int columnIndex) {
        this.number = number;
        this.marked = false;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public int getNumber() {
        return number;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    @Override
    public String toString() {
        return number + ", " +
                "[" + rowIndex + ":" + columnIndex + "], " +
                (isMarked() ? "Marked" : "");
    }
}
