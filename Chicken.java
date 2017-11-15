import java.util.Random;

public class Chicken extends Actor {
    private static Random rng = new Random();

    public Chicken() {
        super();
        this.data = 'C';
        this.currRow = rng.nextInt(9);
        this.currCol = rng.nextInt(9);
        while (currRow == 4 && currCol == 4) {
            this.currRow = rng.nextInt(9);
            this.currCol = rng.nextInt(9);
        }
    }

    public boolean move(Character input) {
		int nextRow = this.currRow;
		int nextCol = this.currCol;
		boolean isValidMove = false;
		while (!isValidMove) {
            int action = rng.nextInt(4);
			switch (action) {
				case 0:
					// move up
					nextRow--;
					break;
				case 1:
					// move down
					nextRow++;
					break;
				case 2:
					// move left
					nextCol--;
					break;
				case 3:
					// move right
					nextCol++;
					break;
			}
			isValidMove = this.areCoordsValid(nextRow, nextCol);
			if (isValidMove) {
				this.currRow = nextRow;
				this.currCol = nextCol;
			} else {
				// Reset to current coords if invalid
				// then iterate till we get a valid move
				nextRow = this.currRow;
				nextCol = this.currCol;
			}
		}
		return true;
    }
}
