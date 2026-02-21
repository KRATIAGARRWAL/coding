class Solution {
    public int find(int i, int j, int nums[], int dp[][]){
        
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        int a=1;
        if(i>0) a=nums[i-1];
        int b=1;
        if(j<nums.length-1) b=nums[j+1];
        for(int k=i;k<=j;k++){
            ans=Math.max(ans, a*b*nums[k]+find(i,k-1,nums,dp)+find(k+1,j,nums,dp));
        }
        return dp[i][j]=ans;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];


        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(i>j) continue;
                int ans=0;
            int a=1;
            if(i>0) a=nums[i-1];
            int b=1;
            if(j<nums.length-1) b=nums[j+1];
            for(int k=i;k<=j;k++){
                 int left = (k == i) ? 0 : dp[i][k-1];
                int right = (k == j) ? 0 : dp[k+1][j];

                dp[i][j] = Math.max(dp[i][j],
                    a * nums[k] * b + left + right
                );
            }
            
        }
        
    }
    return dp[0][n-1];
}
}