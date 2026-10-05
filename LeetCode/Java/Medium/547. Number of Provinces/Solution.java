class Solution {

    int size;
    int[] parent;
    int components;

    public int findCircleNum(int[][] isConnected) {
        size = isConnected.length;
        parent = new int[size];
        components = size;

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        return components;
    }

    private int find(int p) {
        int root = p;

        while (root != parent[root]) {
            root = parent[root];
        }

        while (p != parent[p]) {
            int next = parent[p];
            parent[p] = root;
            p = next;
        }

        return root;
    }

    
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        parent[rootA] = rootB;
        components--;
    }
}