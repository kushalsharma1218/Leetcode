class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], Integer.MAX_VALUE/2);
        }
        for (int[] e : edges) {
            g[e[0]][e[1]] = g[e[1]][e[0]] = e[2];
        }
        for (int k = 0; k < n; ++k){
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int nb = 0;
            for (int j = 0; j < n; ++j) {
                if (i != j && g[i][j] <= distanceThreshold) {
                    nb++;
                }
            }
            if (nb <= min) {
                min = nb;
                ans = i;
            }
        }
        return ans;
    }
}