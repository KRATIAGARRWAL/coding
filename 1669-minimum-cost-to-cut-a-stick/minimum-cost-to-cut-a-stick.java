class Solution {
    public int find(int n , int cuts[], int i, int j, int [][]dp){
        if(i>j) return 0;
        int a=0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(i>0) a=cuts[i-1];
        int b=n;
        if(j<cuts.length-1){
            b=cuts[j+1];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            ans=Math.min(ans, b-a +  find(n,cuts, i, k-1,dp)+ find(n, cuts, k+1, j,dp));
        }
        return dp[i][j]=ans;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int dp[][]=new int[cuts.length][cuts.length];
        for(int i=cuts.length-1;i>=0;i--){
            for(int j=0;j<cuts.length;j++){
                if(i>j)continue;
                int a=0;
                
                if(i>0) a=cuts[i-1];
                int b=n;
                if(j<cuts.length-1){
                    b=cuts[j+1];
                }
                int ans=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int c=0;
                    if(k!=i){
                        c=dp[i][k-1];
                    }
                    int d=0;
                    if(k!=j){
                        d=dp[k+1][j];
                    }
                    ans=Math.min(ans, b-a +  c+d);
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][cuts.length-1];

    }
}