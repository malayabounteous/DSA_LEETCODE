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
    
    private int maxi=Integer.MIN_VALUE;
    private int find(TreeNode root)
    {
        if(root==null)
        return 0;
        int leftSum=Math.max(0,find(root.left));
        int rightSum=Math.max(0,find(root.right));
        
        int ans=leftSum+rightSum+root.val;

        maxi=Math.max(ans,maxi);

        return root.val+Math.max(leftSum,rightSum);
    }

    public int maxPathSum(TreeNode root) {
        
         find(root);
         return maxi;
    }
}