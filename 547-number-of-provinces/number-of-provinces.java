class Solution {
    public void find(int i , int grid[][], int n, int v[]){
        if(i==n) return ;
        v[i]=1;
        for(int j=0;j<n;j++){
            if(v[j]==0 && grid[i][j]==1)
            find(j, grid,n,v);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int v[]=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(v[i]==0) {
                ans++;
                find(i,isConnected, n, v);
            }

        }
        return ans;
    }
}