class Solution {
    // public int find(int k, int prices, int i, int c){
    //     if(i==n)return 0;
    //     if(k==0) return 0;
    //     if(c==0){
    //         return Math.max(find(k,prices, i+1, 1), find())
    //     }
    //     else {
    //         return Math.max(prices[i]+ find(k-1))
    //     }
    // }
    public int maxProfit(int k, int[] prices) {
        
        int n=prices.length;
        int dp[][][]=new int[n+1][2][k+1];
        
        for(int i=n-1;i>=0;i--){
            for(int z=0;z<2;z++)
            for(int j=1;j<=k;j++){
                if(z==0)
                dp[i][0][j]=Math.max(-prices[i]+dp[i+1][1][j], dp[i+1][0][j]);
                else 
                dp[i][1][j]=Math.max(prices[i]+dp[i+1][0][j-1], dp[i+1][1][j]);

               
            }
            
        }
        return dp[0][0][k];
        
    }
}
