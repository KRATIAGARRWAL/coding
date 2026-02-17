class Solution {
    public void find(Set<String> ans, int []a, int []b, int n, int i, int j){
        if(n==0){
            int t1=a[0]+a[1]*2+a[2]*4+a[3]*8;
            int t2= b[0]+b[1]*2+b[2]*4+b[3]*8+b[4]*16+b[5]*32;
            if(t1<12 && t2<60){
                String s=t1+":";
                if(t2<10)s+="0";
                s+=t2;
                ans.add(s);
            }
        }
        for(int k=j;k<6;k++){
            b[k]=1;
            find(ans,a,b,n-1,i,k+1);
            b[k]=0;
        }
        for(int k=i;k<4;k++){
            a[k]=1;
            find(ans,a,b,n-1,k+1,j);
            a[k]=0;
        }
        
        
        
        
    }
    public List<String> readBinaryWatch(int n) {
        Set<String> ans=new HashSet<>();
        if(n>8) return new ArrayList<>(ans);
        int a[]=new int[4];
        int b[]=new int[6];
        find(ans,a,b,n,0,0);
        
        return new ArrayList<>(ans);
    }
}