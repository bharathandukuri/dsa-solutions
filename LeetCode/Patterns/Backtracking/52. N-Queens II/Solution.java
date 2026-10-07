class Solution {

    int count = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        helper(n, board, 0);

        return count;
    }

    public void helper(int n, char[][] board, int c) {
        if (c == n) {
            count++;
            return;
        }

        for (int r = 0; r < n; r++) {
            if (isValid(board, r, c)) {

                board[r][c] = 'Q';

                helper(n, board, c + 1);

                board[r][c] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int r, int c) {
        int n = board.length;

        // row
        for (int j = 0; j < c; j++)
            if (board[r][j] == 'Q')
                return false;

        // upper-left
        for (int i = r - 1, j = c - 1;
             i >= 0 && j >= 0;
             i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // lower-left
        for (int i = r + 1, j = c - 1;
             i < n && j >= 0;
             i++, j--)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }
}