class Solution {
    Boolean dp[][];
    public boolean find(int i, int j,int k, String a, String b, String c){

        if(i==a.length() && j==b.length() && k==c.length())
        return true;
        if(i==a.length()){
            return b.substring(j).equals(c.substring(k));
        }
        if(j==b.length()){
            return a.substring(i).equals(c.substring(k));
        }

        if(dp[i][j]!=null) return dp[i][j];
        

        if(a.charAt(i)==c.charAt(k) && find(i+1,j,k+1,a,b,c))return dp[i][j]=true;

        return dp[i][j]=b.charAt(j)==c.charAt(k) && find(i,j+1,k+1,a,b,c);
    }
    public boolean isInterleave(String a, String b, String c) {
        dp= new Boolean [a.length()][b.length()];
        if(a.length()+b.length()!= c.length()) return false;
        return find(0,0,0,a,b,c);
    }
}