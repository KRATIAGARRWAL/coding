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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>q =new LinkedList<>();
        q.add(root);
        q.add(null);
        long sum=0;
        int ans=1;
        long max=root.val;
        int l=1;
        while(q.size()>0){
            TreeNode curr= q.remove();
            if(curr==null) {
                if(q.size()>0)
                q.add(null);
                if(max<sum){
                    max=sum;
                    ans=l;
                }
                l++;
                sum=0;
                
            }
            else{
                TreeNode left=curr.left;
                TreeNode right=curr.right;
                if(left!=null){
                    q.add(left);
                }
                if(right!=null){
                    q.add(right);
                }
                sum+=curr.val;
            }
        }
        return ans;
    }
}