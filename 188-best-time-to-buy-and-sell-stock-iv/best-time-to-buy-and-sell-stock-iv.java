class Solution {
    public int find(int i, int c, int hold, int[] prices, int n, int dp[][][]){
        if(i == n || c == 0) return 0;

        if(dp[i][c][hold] != -1) return dp[i][c][hold];

        int ans = 0;

        if(hold == 0){
            ans = Math.max(
                -prices[i] + find(i+1, c, 1, prices, n, dp),
                find(i+1, c, 0, prices, n, dp)
            );
        } else {
            ans = Math.max(
                prices[i] + find(i+1, c-1, 0, prices, n, dp),
                find(i+1, c, 1, prices, n, dp)
            );
        }

        return dp[i][c][hold] = ans;
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];

        for(int i=0;i<n;i++)
            for(int j=0;j<=k;j++)
                for(int h=0;h<2;h++)
                    dp[i][j][h] = -1;

        return find(0, k, 0, prices, n, dp);
    }
}
