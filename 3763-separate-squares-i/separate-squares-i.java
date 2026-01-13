class Solution {
    public double separateSquares(int[][] squares) {
        int n=squares.length;
        double min=squares[0][1];
        double max=squares[0][1]+squares[0][2];
        double area=0;
        for(int i=0;i<n;i++){
            if(squares[i][1]<min){
                min=squares[i][1];
            }
            if(max<squares[i][1]+squares[i][2]){
                max=squares[i][1]+squares[i][2];
            }
            area+=squares[i][2]*squares[i][2];
        }
        double limit=0.000001;
        
        while(max-min>limit){
            double mid=(min+max)/2.0;
            double a=0;
            double b=0;
            for(int i=0;i<n;i++){
                if(squares[i][1]>=mid){
                    b+=((double)squares[i][2]*squares[i][2]);
                }
                else if((squares[i][1]+squares[i][2])<=mid){
                    a+=((double)squares[i][2]*squares[i][2]);
                }
                else {
                    b+=(squares[i][1]+squares[i][2]-mid)*squares[i][2];
                    a+=(mid-squares[i][1])*squares[i][2];
                }
            }
            if(b>a){
                min=mid;
            }
            else max=mid;
            
        }

        double ans=Math.round(min*100000.0)/100000.0;

        return ans;
    }
}