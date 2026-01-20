class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int num=nums.get(i);
            if((num & 1)==0){
                ans[i]=-1;
                continue;
            }
            // while((num&1)==1){
            //     num=num>>1;
            // }
            // if(num==0){
            //     ans[i]=nums.get(i)>>1;
            // }
            // else 
            // ans[i]=(nums.get(i)>>1)<<1;
            int k=num/2;
            while((k|k+1)!=num){
               k++;
            }
            ans[i]=k;

        }
        return ans;
    }
}