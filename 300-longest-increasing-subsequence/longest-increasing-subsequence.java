class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            int l=0, r=arr.size();
            while(l<r){
                int mid=(l+r)/2;
                if(arr.get(mid)==nums[i]){
                    break;
                }
                else if(arr.get(mid)<nums[i]){
                    l=mid+1;
                }
                else {
                    r=mid;
                }
            }

            if(l<r){
                continue;
            }
            if(l>arr.size()-1){
                arr.add(nums[i]);
            }
            else arr.set(l,nums[i]);

        }
        return arr.size();
    }
}