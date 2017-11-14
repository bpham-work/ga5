public class Player extends Actor {
    public Player() {
        super();
        this.currRow = 4;
        this.currCol = 4;
        this.data = 'P';
    }

    public void move(char input) {
        int nextRow = this.currRow;
        int nextCol = this.currCol;
        switch (input) {
            case 'w':
                nextRow--;
                break;
            case 'a':
                nextCol--;
                break;
            case 's':
                nextRow++;
                break;
            case 'd':
                nextCol++;
                break;
            default:
                break;
        }
        if (areCoordsValid(nextRow, nextCol)) {
            this.currRow = nextRow;
            this.currCol = nextCol;
        } else {
            System.out.println("You cannot move off the map!");
        }
    }
}
