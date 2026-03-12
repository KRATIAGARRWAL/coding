class Solution {
    public int maxScore(int[] nums, int k) {
        int n=nums.length;
        int k1= n-k;
        int sum=0;
        int curr=0;
        int total=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        for(int i=0;i<k1;i++){
            sum+=nums[i];
        }
        curr=sum;
        int l=0;
        for(int r=k1;r<n;r++,l++){
            curr-=nums[l];
            curr+=nums[r];
            sum=Math.min(curr,sum);
        }

        return total-sum;
    }
}