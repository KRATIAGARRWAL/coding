class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int count=0;
        int min=Math.abs(matrix[0][0]);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]<0){
                    matrix[i][j]=-matrix[i][j];
                    count++;
                }
                min=Math.min(matrix[i][j],min);
                sum+=matrix[i][j];
            }
        }
        if(count%2==0)
        return sum;
        return sum-2*min;
    }
}