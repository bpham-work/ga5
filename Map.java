import java.util.HashMap;

public class Map {
    private char[][] grid = new char[9][9];
    private HashMap<Character, Tuple> previousCoords = new HashMap<>();

    public Map() {
        for (char[] row : grid) {
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                row[colIndex] = '-';
            }
        }
    }

    public void update(int row, int col, char data) {
        Tuple previousCoord = previousCoords.get(data);
        if (previousCoord != null) {
            grid[previousCoord.row][previousCoord.col] = '-';
        }
        previousCoords.put(data, new Tuple(row, col));
        grid[row][col] = data;
    }

    public void printMap() {
        for (char[] row : grid) {
            String mapRow = "";
            for (char colElem : row) {
                mapRow = mapRow + colElem + " ";
            }
            System.out.println(mapRow);
        }
    }

    private class Tuple {
        public int row;
        public int col;

        public Tuple(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
