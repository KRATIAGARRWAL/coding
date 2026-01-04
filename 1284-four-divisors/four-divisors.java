class Solution {
    public int sumFourDivisors(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int sum=0, c=0;
            for(int j=1;j*j<=nums[i];j++){
                if(nums[i]%j==0){
                    int a= j;
                    int b= nums[i]/j;
                    c++;
                    sum+=j;
                    if(b>a){
                        c++;
                        sum+=b;
                    }
                }

            }
            if(c==4) ans+=sum;
        }
        return ans;
    }
}