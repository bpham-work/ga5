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

    public void move(char input) {
        int action = rng.nextInt(4);
        switch (action) {
            case 0:
                moveUp();
                break;
            case 1:
                moveDown();
                break;
            case 2:
                moveLeft();
                break;
            case 3:
                moveRight();
                break;
        }
    }
}
