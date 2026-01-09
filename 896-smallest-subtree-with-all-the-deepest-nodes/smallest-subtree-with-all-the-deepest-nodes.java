/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode find(TreeNode root , HashMap<TreeNode,Integer>hm){
        if(root==null) return null;
        
        int l=hm.get(root.left);
        int r=hm.get(root.right);
        if(l==r) return root;
        if(l>r){
            return find(root.left, hm);
        }
        return find(root.right,hm);

        }
    
    public int dfs(TreeNode root,HashMap<TreeNode,Integer> hm){
        if(root==null) return 0;

        int ans= 1+Math.max(dfs(root.left,hm),dfs(root.right,hm));
        hm.put(root,ans);
        
        
        return ans;

    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        HashMap<TreeNode,Integer> hm=new HashMap<>();
        int t=dfs(root,hm);
        hm.put(null,0);
        TreeNode ans= find(root,hm);
        
        return ans;
    }
}