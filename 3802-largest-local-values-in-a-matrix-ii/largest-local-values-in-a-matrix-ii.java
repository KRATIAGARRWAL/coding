class Solution {
    public int countLocalMaximums(int[][] a) {
        int n = a.length, m = a[0].length;
        int[][][] pre = new int[201][n + 1][m + 1];

        for (int v = 0; v <= 200; v++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    int val = (a[i - 1][j - 1] > v) ? 1 : 0;
                    pre[v][i][j] = val + pre[v][i - 1][j] + pre[v][i][j - 1] - pre[v][i - 1][j - 1];
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = a[i][j];
                if (x == 0) continue;

                int r1 = Math.max(0, i - x);
                int c1 = Math.max(0, j - x);
                int r2 = Math.min(n - 1, i + x);
                int c2 = Math.min(m - 1, j + x);

                int cnt = pre[x][r2 + 1][c2 + 1]
                        - pre[x][r1][c2 + 1]
                        - pre[x][r2 + 1][c1]
                        + pre[x][r1][c1];

                int[][] d = {{-x,-x},{-x,x},{x,-x},{x,x}};

                for (int[] dir : d) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                        if (a[ni][nj] > x) cnt--;
                    }
                }

                if (cnt == 0) ans++;
            }
        }

        return ans;
    }
}