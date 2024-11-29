package global;

public enum CellState {
    EMPTY("   "), X(" X "), O(" O ");

    private final String representation;

    CellState(String representation) {
        this.representation = representation;
    }

    public String getRep() {
        return representation;
    }
} 