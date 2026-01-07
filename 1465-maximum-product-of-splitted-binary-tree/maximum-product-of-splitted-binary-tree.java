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
class mine{
    TreeNode root;
    long left;
    long right;
}
class Solution {
    public long sum(TreeNode root){
        if(root==null) return 0;
        root.val+= sum(root.left)+ sum(root.right);
        return root.val;
    }
    public long ans(TreeNode root, long val){
        if(root==null) return 0;
        long max= (val-root.val )* (root.val);

        max=Math.max(ans(root.left, val), max);
        max=Math.max(ans(root.right,val), max);
        return max;
    }
    public int maxProduct(TreeNode root) {
        long res=sum(root);
        System.out.println(res);
        return (int)(ans(root, root.val)%1000000007);
        
    }
}