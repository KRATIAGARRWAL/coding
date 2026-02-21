class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        int dp[]=new int[n];
        int max=1;
        Arrays.sort(words, (a,b)->a.length()-b.length());
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                boolean f=true;
                int l1=words[i].length();
                int l2=words[j].length();
                int k1=0, k2=0;
                while(k1<l1 && k2<l2){
                    if(words[i].charAt(k1)==words[j].charAt(k2)){
                        k1++;
                        k2++;
                    }
                    else k1++;
                }
                if(l1==l2+1 && k2==l2){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
                
            }
            

            max=Math.max(dp[i],max); 
        }
        return max;
    }
}