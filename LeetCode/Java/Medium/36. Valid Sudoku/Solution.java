class Solution {
    public boolean checkRow(char[][] board, int row) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < board[row].length; i++) {
            char c = board[row][i];
            if (c != '.') {
                int index = c - '1';
                if (seen[index]) {
                    return false;
                }
                seen[index] = true;
            }
        }
        return true;
    }

    public boolean checkColumn(char[][] board, int column) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < board.length; i++) {
            char c = board[i][column];
            if (c != '.') {
                int index = c - '1';
                if (seen[index]) {
                    return false;
                }
                seen[index] = true;
            }
        }
        return true;
    }

    public boolean checkGrid(char[][] board, int grid) {
        boolean[] seen = new boolean[9];
        int x = (grid / 3) * 3;
        int y = (grid % 3) * 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '1';
                    if (seen[index]) {
                        return false;
                    }
                    seen[index] = true;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i) || !checkColumn(board, i) || !checkGrid(board, i)) {
                return false;
            }
        }
        return true;
    }
}
