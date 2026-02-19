class Solution {
    public int maxProfit(int[] arr) {
        int p=0;
        int n=arr.length;
        int i=0;
        while(i<n){
            int j=i+1;
            while(j<n && arr[j]>arr[j-1]){
                j++;
            }
            p+= arr[j-1]-arr[i];
            i=j;

        }
        return p;
    }
}