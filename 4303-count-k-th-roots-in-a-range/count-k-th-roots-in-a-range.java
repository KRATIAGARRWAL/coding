class Solution {
    public int countKthRoots(int l, int r, int k) {
        long left=0;
        long right = r;
        long ans1=0;
        while(left<=right){
            long mid=(left+right)/2;
            double temp= Math.pow(mid,k);
            if(temp<=(double)r){
                ans1=mid+1;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        System.out.println(ans1);
        left=0;
        right = l;
        long ans2=0;
        while(left<=right){
            long mid=(left+right)/2;
            double temp= Math.pow(mid,k);
            if(temp<(double)l){
                ans2=mid+1;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        return (int)(ans1-ans2);
    }
}
