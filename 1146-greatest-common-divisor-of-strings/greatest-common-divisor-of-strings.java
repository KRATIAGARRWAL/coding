class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n1=str1.length();
        int n2=str2.length();

        int n= Math.min(n1,n2);
        String ans="";
        for(int i=0;i<n;i++){
            
            if(n1%(i+1)!=0 || n2%(i+1)!=0) continue;
            String s= str1.substring(0,i+1);
            boolean f=true;
            for(int j=0;j<n1;j+=(i+1)){
                String s1=str1.substring(j, i+1+j);
                if(!s.equals(s1)){
                    f=false;
                    break;
                }
            }

            for(int j=0;j<n2 && f; j+=(i+1)){
                String s1=str2.substring(j, i+1+j);
                if(!s.equals(s1)){
                    f=false;
                    break;
                }
            }

            if(f)ans=s;
        }
        return ans;
    }
}