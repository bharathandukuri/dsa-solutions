class Pair {
    int node;
    double weight;

    Pair(int node, double weight) {
        this.node = node;
        this.weight = weight;
    }
}

class UnionFind {
    int[] parent;
    double[] weight;

    public UnionFind(int n) {
        parent = new int[n];
        weight = new double[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1.0;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            int origParent = parent[x];
            parent[x] = find(origParent);

            weight[x] *= weight[origParent];
        }
        return parent[x];
    }

    public void union(int x, int y, double value) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return;

        parent[rootX] = rootY;

        weight[rootX] = (weight[y] * value) / weight[x];
    }

    public double getRatio(int x, int y) {
        if (find(x) != find(y))
            return -1.0;
        return weight[x] / weight[y];
    }
}

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Integer> map = new HashMap<>();
        int id = 0;

        for (List<String> eq : equations) {
            for (String var : eq) {
                if (!map.containsKey(var)) {
                    map.put(var, id++);
                }
            }
        }

        UnionFind uf = new UnionFind(id);

        for (int i = 0; i < equations.size(); i++) {
            int x = map.get(equations.get(i).get(0));
            int y = map.get(equations.get(i).get(1));
            uf.union(x, y, values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            if (!map.containsKey(a) || !map.containsKey(b)) {
                res[i] = -1.0;
            } else {
                res[i] = uf.getRatio(map.get(a), map.get(b));
            }
        }

        return res;
    }
}