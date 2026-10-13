
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();

        int[][] dirs = {
                { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }
        };

        queue.offer(new int[] {
                entrance[0], entrance[1], 0
        });

        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            int i = pos[0];
            int j = pos[1];
            int steps = pos[2];

            // Exit must not be the entrance itself
            if ((i != entrance[0] || j != entrance[1]) && (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
                return steps;
            }

            for (int[] d : dirs) {
                int x = i + d[0];
                int y = j + d[1];

                if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.' && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[] {x, y, steps + 1});
                }
            }
        }

        return -1;
    }
}
