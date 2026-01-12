class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk=new Stack<>();
        stk.add(-1);
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)==')'){
                stk.pop();
                if(stk.size()>0){
                    ans= Math.max(i-stk.peek(),ans);
                }
                else stk.push(i);
            }
            else stk.push(i);
            
        }
        return ans;
    }
}