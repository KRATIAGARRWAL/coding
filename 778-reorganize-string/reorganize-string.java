class Solution {
    public String reorganizeString(String s) {
        char arr[]= s.toCharArray();
        Arrays.sort(arr);
        int n=arr.length;
        StringBuilder str=new StringBuilder("");
        int i=0, j=0;
        int fre[]=new int[26];
        for(i=0;i<n;i++){
            fre[arr[i]-'a']++;
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> b[1]-a[1]);

        for( i=0;i<26;i++){
            if(fre[i]>0){
                pq.add(new int[]{i,fre[i]});
            }
        }
        int prev[]={-1,0};
        while(pq.size()>0){
            int [] p= pq.remove();
            if(p[1]>(n+1)/2) return "";
            str.append(""+(char)(p[0]+'a'));
            p[1]--;
            if(prev[1]>0) pq.add(prev);
            prev=p;
        }

        return new String(str);
    }
}