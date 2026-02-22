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
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            
                dp[i]=-1;
            
        }
        
        
        return find(0, s,s.length(),dp)-1;
    }
}