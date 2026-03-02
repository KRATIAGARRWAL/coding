class Solution {
    public int minSwaps(int[][] grid) {
        int n=grid.length;
        // int rows[]=new int[m];
        int ans=0;
        for(int i=0;i<n;i++){
            int f=-1;
            for(int j=i;j<n;j++){
                int count=0;
                for(int k=i+1;k<n;k++){
                    count+=(1-grid[j][k]);
                }
                if(count== n-i-1){
                    f=j;
                    break;
                }
                
            }
            if(f==-1)return -1;
            for(int j=f-1;j>=i;j--){
                ans++;
                for(int k=0;k<n;k++){
                    int temp=grid[j][k];
                    grid[j][k]=grid[j+1][k];
                    grid[j+1][k]=temp;
                }
            }


            

        }
        return ans;

    }
}