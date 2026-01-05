class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans=0;
        int n=gas.length;
        int sum=0, sum2=0;
        for(int i=0;i<n;i++){
            sum+=gas[i]-cost[i];
            sum2+=gas[i]-cost[i];
            
            if(sum<0){
                sum=0;
                
                ans=i+1;
            }
            else if(i==n-1 && sum2>=0) return ans;
        }
        return -1;
        
    }
}