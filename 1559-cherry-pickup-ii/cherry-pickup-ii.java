class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        // ---------- Base case: last row ----------
        for (int j = 0; j < n; j++) {
            for (int y = 0; y < n; y++) {
                if (j == y)
                    dp[m-1][j][y] = grid[m-1][j];
                else
                    dp[m-1][j][y] = grid[m-1][j] + grid[m-1][y];
            }
        }

        // ---------- Fill from bottom to top ----------
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                for (int y = 0; y < n; y++) {

                    int ans = grid[i][j];
                    if (j != y) ans += grid[i][y];

                    int best = 0;

                    for (int a = -1; a <= 1; a++) {
                        int j1 = j + a;
                        if (j1 < 0 || j1 >= n) continue;

                        for (int b = -1; b <= 1; b++) {
                            int y1 = y + b;
                            if (y1 < 0 || y1 >= n) continue;

                            best = Math.max(best, dp[i+1][j1][y1]);
                        }
                    }

                    dp[i][j][y] = ans + best;
                }
            }
        }

        return dp[0][0][n-1];
    }
}