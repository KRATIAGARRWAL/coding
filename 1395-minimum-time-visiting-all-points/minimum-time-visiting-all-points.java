class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n=points.length;
        int ans=0;
       
        for(int i=1;i<n;i++){
            int a=Math.abs(points[i][0]-points[i-1][0]);
            int b=Math.abs(points[i][1]-points[i-1][1]);

            ans+= a;
            ans+=b;
            ans-=Math.min(a,b);
        }

        return ans;
    }
}