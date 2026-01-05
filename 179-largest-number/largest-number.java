class Solution {
    int compare(String a,String b){
        int n1=a.length();
        int n2=b.length();
        int i=0;
        while(i<n1 && i<n2){
            if(a.charAt(i)>b.charAt(i))
            return -1;
            else if(a.charAt(i)<b.charAt(i)) return 1;
            i++;
        }
        if(n1==n2) return 0;

        if(n1>n2) return compare(a.substring(n2),b);
        return compare(a,b.substring(n1));
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