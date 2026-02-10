class Solution {
    public int find(int i, int j, int y, int [][]grid, int dp[][][]){
        if(dp[i][j][y]!=-1) return dp[i][j][y];
        int m=grid.length;
        int n=grid[0].length;
        int ans=grid[i][j];
        if(j!=y){
            ans+=grid[i][y];
        }
        if(i==m-1)return dp[i][j][y]= ans;
        int temp=0;
        for(int a=-1;a<2;a++){
            int j1=j+a;
            if(j1>=0 && j1<n)
            for(int b=-1;b<2;b++){
                int y1=y+b;
                if(y1>=0 && y1<n){
                    temp=Math.max(temp,find(i+1,j1,y1,grid,dp));
                }
            }
        }
        return dp[i][j][y]=ans+temp;
    }
    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int dp[][][]=new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return find(0,0,grid[0].length-1,grid,dp);
    }
}