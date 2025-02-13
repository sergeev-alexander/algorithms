package sergeev.alexander;

public class Temp {

    // #79
    public static void main(String[] args) {
        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}};
        String s = "AAB";
        System.out.println(exist(board, s));
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] wordArr = word.toCharArray();
        int wordLength = wordArr.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == wordArr[0]) {
                    int mPos = i;
                    int nPos = j;
                    int charPos = 1;
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[mPos][nPos] = true;
                    while (true) {
                        if (charPos == wordLength) {
                            return true;
                        }
                        if (isValidCell(mPos + 1, nPos, m, n)
                                && board[mPos + 1][nPos] == wordArr[charPos]
                                && !visited[mPos + 1][nPos]) {
                            visited[mPos + 1][nPos] = true;
                            charPos++;
                            mPos++;
                            continue;
                        }
                        if (isValidCell(mPos - 1, nPos, m, n)
                                && board[mPos - 1][nPos] == wordArr[charPos]
                                && !visited[mPos - 1][nPos]) {
                            visited[mPos - 1][nPos] = true;
                            charPos++;
                            mPos--;
                            continue;
                        }
                        if (isValidCell(mPos, nPos + 1, m, n)
                                && board[mPos][nPos + 1] == wordArr[charPos]
                                && !visited[mPos][nPos + 1]) {
                            visited[mPos][nPos + 1] = true;
                            charPos++;
                            nPos++;
                            continue;
                        }
                        if (isValidCell(mPos, nPos - 1, m, n)
                                && board[mPos][nPos - 1] == wordArr[charPos]
                                && !visited[mPos][nPos - 1]) {
                            visited[mPos][nPos - 1] = true;
                            charPos++;
                            nPos--;
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isValidCell(int row, int col, int m, int n) {
        if (row < 0 || row >= m) return false;
        return col >= 0 && col < n;
    }
}