import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by sreedish.ps on 12/11/15.
 */
public class ChristmasCard {

    //The main grid
    static boolean grid[][] = new boolean[25][25]; //Black = true = 1 ; white = false = 0;
    //Already black cells
    static HashSet<Cell> blackCells = new HashSet<Cell>();
    static ArrayList<Integer> rowsRules[] = new ArrayList[25];
    static ArrayList<Integer> columnRules[] = new ArrayList[25];

    public static void main(String[] args) {
        //populate the already fixed black cells
        blackCells.add(new Cell(3, 3));
        blackCells.add(new Cell(3, 4));
        blackCells.add(new Cell(3, 12));
        blackCells.add(new Cell(3, 13));
        blackCells.add(new Cell(3, 21));
        blackCells.add(new Cell(8, 6));
        blackCells.add(new Cell(8, 7));
        blackCells.add(new Cell(8, 10));
        blackCells.add(new Cell(8, 14));
        blackCells.add(new Cell(8, 15));
        blackCells.add(new Cell(8, 18));
        blackCells.add(new Cell(16, 6));
        blackCells.add(new Cell(16, 11));
        blackCells.add(new Cell(16, 16));
        blackCells.add(new Cell(16, 20));
        blackCells.add(new Cell(21, 3));
        blackCells.add(new Cell(21, 4));
        blackCells.add(new Cell(21, 9));
        blackCells.add(new Cell(21, 10));
        blackCells.add(new Cell(21, 15));
        blackCells.add(new Cell(21, 20));
        blackCells.add(new Cell(21, 21));

        //populate Row rules
        rowsRules[0] = new ArrayList();
        rowsRules[0].add(7);


        generateGrid(0, 0, 100, false);

    }

    private static void generateGrid(int x, int y, int blackCount,boolean check) {

    }

    private static void check() {
        printIt();
    }

    static void printIt() {
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if (blackCells.contains(new Cell(i, j))) {
                    System.out.print(1);
                    continue;
                }
                if (grid[i][j]) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}

class Cell {
    int x;
    int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        return y == cell.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
