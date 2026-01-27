class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        int m= edges.length;
        for(int i=0;i<m;i++){
            g.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            g.get(edges[i][1]).add(new int[]{edges[i][0], 2*edges[i][2]});
        }

        int v[]=new int[n];
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);

        q.add(new int[]{0,0});

        while(q.size()>0){
            int t[]= q.remove();

            if(t[1]==n-1) return t[0];
            if(v[t[1]]==1) continue;

            v[t[1]]=1;
            List<int[]> l=g.get(t[1]);
            

            for(int i=0;i<l.size();i++){
                int [] p= l.get(i);
                if(v[p[0]]==1) continue;

                q.add(new int[]{t[0]+p[1], p[0]});

            }
        }

        return -1;
    }
}