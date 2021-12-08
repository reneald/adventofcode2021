package be.leanderonline;

public abstract class AbstractDirectionsInterpreter {
    private int horizontalPosition = 0;
    private int depth = 0;
    private int aim = 0;

    public int getCurrentPosition () {
        return horizontalPosition * depth;
    }

    protected int getHorizontalPosition() {
        return horizontalPosition;
    }

    protected void setHorizontalPosition(int horizontalPosition) {
        this.horizontalPosition = horizontalPosition;
    }

    protected int getDepth() {
        return depth;
    }

    protected void setDepth(int depth) {
        this.depth = depth;
    }

    protected int getAim() {
        return aim;
    }

    protected void setAim(int aim) {
        this.aim = aim;
    }
}
