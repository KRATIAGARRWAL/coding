class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans= new ArrayList<>();
        ans.add(0);
        int s=1;
        for(int i=1;i<=n;i++){
            List<Integer> temp=new ArrayList<>(ans);
            for(int j= temp.size()-1;j>=0;j--){
                ans.add( temp.get(j)^s);
            }
            s*=2;
        }
        return ans;
    }
}
