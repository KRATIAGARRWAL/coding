class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int arr[]=new int[n];
        int ans=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0') arr[j]=0;
                else arr[j]++;
            }
            Stack<Integer> stk=new Stack<>();

            for(int j=0;j<=n;j++){
                int h= (j==n) ? -1: arr[j];
                
                while(stk.size()>0 && h < arr[stk.peek()]){
                    int l=arr[stk.pop()];
                    int b=(stk.size()==0) ?j :j- stk.peek()-1;
                    ans=Math.max(ans, l*b);

                }

                stk.push(j);
            }
           
        }


        return ans;

    }
}


