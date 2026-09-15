class NumMatrix {

    private int[][] prefix;
    public NumMatrix(int[][] matrix) {
        prefix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                prefix[i + 1][j + 1] = sum + prefix[i][j + 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int topLeft = prefix[row1][col1];
        int topRight = prefix[row1][col2 + 1];
        int bottomLeft = prefix[row2 + 1][col1];
        int bottomRight = prefix[row2 + 1][col2 + 1];

        return bottomRight - topRight - bottomLeft + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */