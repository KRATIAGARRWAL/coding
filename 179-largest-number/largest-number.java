class Solution {
    int compare(String a,String b){
        int n1=a.length();
        int n2=b.length();
        String temp1= a+b;
        String temp2=b+a;
        a=temp1;
        b=temp2;
        int i=0;
        while(i<temp1.length()){
            if(a.charAt(i)>b.charAt(i))
            return -1;
            else if(a.charAt(i)<b.charAt(i)) return 1;
            i++;
        }
        return 0;

    }
    public String largestNumber(int[] nums) {
        ArrayList<String> temp=new ArrayList<>();
        for(int num:  nums){
            temp.add(""+num);
        }

        Collections.sort(temp, (a,b)->compare(a,b));
        String ans="";
        for(String t: temp)ans+=t;

        if(ans.charAt(0)=='0') return "0";
        return ans;

    }
}