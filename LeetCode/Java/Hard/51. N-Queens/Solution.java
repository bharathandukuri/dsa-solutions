class Solution {

    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        helper(n, board, 0);

        return result;
    }

    public void helper(int n, char[][] board, int c) {
        if (c == n) {
            List<String> solution = new ArrayList<>();

            for (char[] row : board) {
                solution.add(new String(row));
            }

            result.add(solution);
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