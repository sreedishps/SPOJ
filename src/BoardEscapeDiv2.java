/**
 * Created by sreedish.ps on 1/27/16.
 */
public class BoardEscapeDiv2 {

    public static void main(String[] args) {
        String s[] ={"##E###",
                     "...T.E"};

        System.out.println(findWinner(s, 27));
    }

    static int board[][] = new int[100][100], rows, cols;

    public static String findWinner(String[] s, int k) {
        rows = s.length;
        cols = s[0].length();
        int startx = 0, starty = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = -1;
                if (s[i].charAt(j) == 'T') {
                    startx = i;
                    starty = j;
                }
            }
        }

        String answer = canWin(startx, starty, k, s) ? "Alice" : "Bob";
        return answer;
    }

    private static boolean canWin(int x, int y, int k, String s[]) {
        if (board[x][y] == 1) {
            return true;
        } else if (board[x][y] == -1) {
            if (k == 0 || s[x].charAt(y) == 'E') {
                board[x][y] = 0;
            } else {
                int dx[] = {0, 0, -1, 1};
                int dy[] = {1, -1, 0, 0};
                int result = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if ((nx >= 0) && (nx < rows) && (ny >= 0) && (ny < cols)) {
                        if (s[nx].charAt(ny) != '#') {
                            if (!canWin(nx, ny, k - 1, s)) {
                                result = 1;
                            }
                        }
                    }

                }
                board[x][y] = result;
            }
        }


        if (board[x][y] == 1) {
            return true;
        } else {
            return false;
        }
    }
}
