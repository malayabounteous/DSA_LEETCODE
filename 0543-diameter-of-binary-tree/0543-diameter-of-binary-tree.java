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
    int ans=0;
    private int diameter(TreeNode root)
    {
        if(root==null)return 0;

        int l=diameter(root.left);
        int r=diameter(root.right);

        ans=Math.max(l+r,ans);
        return 1+Math.max(l,r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
         
         diameter(root);
         return ans;
    }
}