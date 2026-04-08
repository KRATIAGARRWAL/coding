class Solution {
    long find(int i,int f,int nums[],long dp[][]){
        if(i==nums.length) return 0;
        if(dp[i][f]!=-1) return dp[i][f];

        long ans=find(i+1,f,nums,dp);

        if(f==1){
            ans=Math.max(ans,nums[i]+find(i+1,0,nums,dp));
        } else {
            ans=Math.max(ans,-nums[i]+find(i+1,1,nums,dp));
        }

        return dp[i][f]=ans;
    }

    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long dp[][]=new long[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return find(0,1,nums,dp);
    }
}