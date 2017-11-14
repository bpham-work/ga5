public abstract class Actor {
    protected int currRow;
    protected int currCol;
    protected char data;

    public boolean areCoordsValid(int row, int col) {
        return row >= 0 && row < 9 &&
            col >= 0 && col < 9;
    }

    public abstract boolean move(Character input);

    public int getRow() {
        return currRow;
    }

    public int getCol() {
        return currCol;
    }

    public char getData() {
        return data;
    }
}
