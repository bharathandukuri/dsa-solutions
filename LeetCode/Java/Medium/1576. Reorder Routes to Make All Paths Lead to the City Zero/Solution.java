
class Solution {
    List<int[]>[] graph;
    int changes = 0;

    public int minReorder(int n, int[][] connections) {
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {
            int a = edge[0];
            int b = edge[1];

            graph[a].add(new int[]{b, 1});
            graph[b].add(new int[]{a, 0});
        }

        dfs(0, -1);

        return changes;
    }

    private void dfs(int node, int parent) {
        for (int[] edge : graph[node]) {
            int neighbor = edge[0];
            int cost = edge[1];

            if (neighbor == parent) {
                continue;
            }

            changes += cost;
            dfs(neighbor, node);
        }
    }
}
