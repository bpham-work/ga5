import java.util.Scanner;

public class RPG {
    public static void main(String[] args) {
        Map map = new Map();
        Player player = new Player();
        Chicken chicken = new Chicken();

        map.update(player.getRow(), player.getCol(), player.getData());
        map.update(chicken.getRow(), chicken.getCol(), chicken.getData());
        map.printMap();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("up: w | down: s | left: a | right : d | quit: q");
			boolean isUserMoveValid = false;
			while (!isUserMoveValid) {
				System.out.print("your move: ");
				char userInput = scanner.next().charAt(0);
				if (userInput == 'q') {
					System.out.println("Exiting...");
					System.exit(0);
				}
				isUserMoveValid = player.move(userInput);
				if (isUserMoveValid) {
					map.update(player.getRow(), player.getCol(), player.getData());
				}
			}

			// Check if player has moved onto chicken
            if (hasPlayerWon(player, chicken)) {
                map.printMap();
                System.out.println("Chicken captured!");
                System.out.println("Game over!");
                System.exit(0);
            }

            chicken.move(null);
            map.update(chicken.getRow(), chicken.getCol(), chicken.getData());
            map.printMap();

			// Check if chicken has moved onto player
            if (hasPlayerWon(player, chicken)) {
                System.out.println("Chicken captured!");
                System.out.println("Game over!");
                System.exit(0);
            }
        }
    }

    private static boolean hasPlayerWon(Player player, Chicken chicken) {
        return player.getRow() == chicken.getRow() &&
            player.getCol() == chicken.getCol();
    }
}
