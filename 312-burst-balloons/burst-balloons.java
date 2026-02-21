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
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return find(0,n-1, nums,dp);
    }
}