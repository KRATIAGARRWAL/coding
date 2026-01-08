class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int mat[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[i][j]= nums1[i]*nums2[j];

                
            }
            
        }

        for(int i=1;i<m;i++){
            mat[i][0]=Math.max(mat[i-1][0],mat[i][0]);
        }
        for(int i=1;i<n;i++){
            mat[0][i]=Math.max(mat[0][i-1],mat[0][i]);
        }
        

        for(int i=1;i<m;i++){
            
            for(int j=1;j<n;j++){
                mat[i][j]=Math.max(mat[i][j], Math.max(mat[i-1][j-1]+mat[i][j], Math.max(mat[i-1][j],mat[i][j-1])));

                
            }
        }
        return mat[m-1][n-1];
    }
}