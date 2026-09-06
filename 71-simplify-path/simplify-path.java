class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk=new Stack<>();
        String p[]= path.split("/");
        for(int i=0;i<p.length;i++){
            // System.out.print(p[i]+" ??");
            if(p[i].equals("") || p[i].equals("."))continue;
            if(p[i].equals("..")){
                if(stk.size()>0)
                stk.pop();
            } 
            else stk.push(p[i]);
        }
        if(stk.size()==0) return "/";
        StringBuilder ans=new StringBuilder("");
        while(stk.size()>0){
            ans.insert(0,"/"+stk.pop());
        }
        return ans.toString();
    }
}