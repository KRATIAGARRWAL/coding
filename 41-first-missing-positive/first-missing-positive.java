class Solution {
    public int firstMissingPositive(int[] nums) {
        int n= nums.length;
        

        for(int i=0;i<n;i++){
            int s=nums[i];

            int p= s-1;
            while(p>=0 && p<n){
                int st= nums[p];
                if((p+1)==st)break;

                nums[p]=p+1;
                p=st-1;
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]!=(i+1)) return i+1;
        }
        return n+1;
    }
}