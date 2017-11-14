import java.util.HashMap;

public class Map {
    private char[][] grid = new char[9][9];
    private HashMap<Character, Coordinate> previousCoords = new HashMap<>();

    public Map() {
        for (char[] row : grid) {
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                row[colIndex] = '-';
            }
        }
    }

    public void update(int row, int col, char data) {
        Coordinate previousCoord = previousCoords.get(data);
        if (previousCoord != null) {
            char oldChar = grid[previousCoord.row][previousCoord.col];
			if (oldChar == data) {
				// Reset spot if another Actor has not moved into it
				grid[previousCoord.row][previousCoord.col] = '-';
			}
        }
        previousCoords.put(data, new Coordinate(row, col));
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

    private class Coordinate {
        public int row;
        public int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
