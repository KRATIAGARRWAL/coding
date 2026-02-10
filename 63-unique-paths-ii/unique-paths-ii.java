class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n=grid[0].length;
        int m=grid.length;
        int dp[][]=new int[m+1][n+1];

        dp[1][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(grid[i-1][j-1]==1)dp[i][j]=0;
                else if(dp[i][j]==0)dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}