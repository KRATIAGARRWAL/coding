class Solution {
    public int find(int arr[], int i, int n, int k, int dp[]){
        if(i==n) return 0;
        if(dp[i]!=-1)return dp[i];
        int max=0;

        int ans=0;
        for(int j=i;j<i+k && j<n;j++){
            max=Math.max(max,arr[j]);
            ans=Math.max(ans, max*(j-i+1)+find(arr,j+1,n,k,dp));
        }
        return dp[i]=ans;

    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return find(arr,0,arr.length,k, dp);
    }
}