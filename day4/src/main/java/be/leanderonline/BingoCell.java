package be.leanderonline;

public class BingoCell {
    private boolean marked;
    private final int number;

    public BingoCell(int number) {
        this.number = number;
        this.marked = false;
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
}
