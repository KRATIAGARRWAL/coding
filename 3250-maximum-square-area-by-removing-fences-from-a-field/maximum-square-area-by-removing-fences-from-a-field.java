class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        HashSet<Integer> set=new HashSet<>();
        int l1=hFences.length;
        set.add(m-1);
        for(int i=0;i<l1;i++){
            set.add(hFences[i]-1);
            set.add(m-hFences[i]);
        }

        for(int i=0;i<l1;i++){
            for(int j=i+1;j<l1;j++){
                set.add(Math.abs(hFences[i]-hFences[j]));
            }
        }

        

        int l2=vFences.length;
        int max=-1;

        for(int i=0;i<l2;i++){
            int val= vFences[i]-1;
            if(set.contains(val)){
                max=Math.max(max,val);
            }
            val=n-vFences[i];
            if(set.contains(val)){
                max=Math.max(max,val);
            }
            for(int j=i+1;j<l2;j++){
                val=Math.abs(vFences[i]-vFences[j]);
                if(set.contains(val)){
                    max=Math.max(max,val);
                }
            }

        }
        if(set.contains(n-1)){
            max=Math.max(max,n-1);
        }

        if(max==-1) return -1;
        return (int)(((long)max*max)%1000000007);
    }
}