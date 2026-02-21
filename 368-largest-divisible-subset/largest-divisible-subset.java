class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int hash[]=new int[n];
        int max=0;
        Arrays.sort(nums);
        
        for(int i=0;i<n;i++){
            dp[i]=1;
            hash[i]=-1;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0)
                if(dp[i]< dp[j]+1){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            if(dp[max]<dp[i]){
                max=i;
            }
        }

        List<Integer> ans=new ArrayList<>();

        while(max!=-1){
            System.out.println(max);
            ans.add(nums[max]);
            max=hash[max];
        }
        return ans;
    }
}