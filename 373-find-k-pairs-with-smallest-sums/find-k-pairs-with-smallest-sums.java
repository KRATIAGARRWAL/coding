class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.add(new int[]{nums1[0]+nums2[0], 0,0});
        int n= nums1.length;
        int m= nums2.length;
        HashMap<Integer, HashSet<Integer>> hm =new HashMap<>();
        List<List<Integer>> ans =new ArrayList<>();
        while(pq.size()>0 && ans.size()<k){
            int p[]= pq.remove();
            List<Integer> small =new ArrayList<>();
            small.add(nums1[p[1]]);
            small.add(nums2[p[2]]);
            ans.add(small);
            if(pq.size()<k){
            
            if(p[1]+1<n && (!hm.containsKey(p[1]+1) || !hm.get(p[1]+1).contains(p[2]))) {pq.add(new int[]{nums1[p[1]+1]+nums2[p[2]], p[1]+1, p[2]});
            HashSet<Integer> set = hm.getOrDefault(p[1]+1, new HashSet<>());
            hm.put(p[1]+1, set);
            set.add(p[2]);
            }
            if(p[2]+1<m && (!hm.containsKey(p[1]) || !hm.get(p[1]).contains(p[2]+1))) pq.add(new int[]{nums1[p[1]]+nums2[p[2]+1], p[1], p[2]+1});
            HashSet<Integer> set = hm.getOrDefault(p[1], new HashSet<>());
            hm.put(p[1], set);
            set.add(p[2]+1);
            }
        }

        return ans;

        
    }
}