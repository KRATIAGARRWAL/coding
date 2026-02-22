class Solution {
    public int find(int i, String s, int n, int dp[]){
        
        if(i==n)return 0;
        int ans= n-i;
       
        if(dp[i]!=-1)return dp[i];
        for(int j=i;j<n;j++){
            int st=i, e= j;
            while(st<e && s.charAt(st)==s.charAt(e)){
                st++;
                e--;
            }
            if(st>=e){
               
                ans=Math.min(ans,1+ find(j+1, s,n,dp));
                
            }
        }
        return dp[i]=ans;
    }
    public int minCut(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int ans= n-i;
            for(int j=i;j<n;j++){
                int st=i, e= j;
                while(st<e && s.charAt(st)==s.charAt(e)){
                    st++;
                    e--;
                }
                if(st>=e){
                
                    ans=Math.min(ans,1+ dp[j+1]);
                    
                }
            }
            dp[i]=ans;
        }
        
        
        return dp[0]-1;
    }
}