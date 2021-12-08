package be.leanderonline;

public enum Direction {
    FORWARD ("forward"),
    DOWN ("down"),
    UP ("up");

    private final String message;

    Direction(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
