public abstract class Actor {
    protected int currRow;
    protected int currCol;
    protected char data;

    public boolean areCoordsValid(int row, int col) {
        return row >= 0 && row < 9 &&
            col >= 0 && col < 9;
    }

    public abstract void move(char input);

    public int getRow() {
        return currRow;
    }

    public int getCol() {
        return currCol;
    }

    public char getData() {
        return data;
    }

    public void moveUp() {
        if (areCoordsValid(this.currRow - 1, this.currCol)) {
            this.currRow--;
        }
    }

    public void moveDown() {
        if (areCoordsValid(this.currRow + 1, this.currCol)) {
            this.currRow++;
        }
    }

    public void moveLeft() {
        if (areCoordsValid(this.currRow, this.currCol - 1)) {
            this.currCol--;
        }
    }

    public void moveRight() {
        if (areCoordsValid(this.currRow, this.currCol + 1)) {
            this.currCol++;
        }
    }
}
