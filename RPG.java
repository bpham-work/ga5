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
            System.out.print("your move:");
            char userInput = scanner.next().charAt(0);
            if (userInput == 'q') {
                System.out.println("Exiting...");
                break;
            }
            chicken.move('a');
            map.update(chicken.getRow(), chicken.getCol(), chicken.getData());
            player.move(userInput);
            map.update(player.getRow(), player.getCol(), player.getData());
            map.printMap();
            if (hasPlayerWon(player, chicken)) {
                System.out.println("Chicken captured!");
                System.out.println("Game over!");
                break;
            }
        }
    }

    private static boolean hasPlayerWon(Player player, Chicken chicken) {
        return player.getRow() == chicken.getRow() &&
            player.getCol() == chicken.getCol();
    }
}
