class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = 0;

        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();

                for (int[] dir : dirs) {
                    int dx = pos[0] + dir[0];
                    int dy = pos[1] + dir[1];

                    if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;

                    if (grid[dx][dy] != 1) continue;

                    grid[dx][dy] = 2;
                    fresh--;
                    queue.offer(new int[]{dx, dy});
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}