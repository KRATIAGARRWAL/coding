class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int ans=1;

        int h=1;
        int v=1;

        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int j=0;
        for(int i=1;i<hBars.length;i++){

            if(hBars[i]-1==hBars[i-1] ){
                h=Math.max(h, i-j+1);
                
            }
            else j=i;
        }
        j=0;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]-1==vBars[i-1] ){
                v=Math.max(v, i-j+1);
                
            }
            else j=i;
        }
        v=Math.min(v,m);
        h=Math.min(h,n);
        ans+=Math.min(h,v);
        return ans*ans;
    }
}