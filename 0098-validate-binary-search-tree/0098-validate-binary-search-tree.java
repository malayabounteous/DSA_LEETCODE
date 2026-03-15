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
    
    private boolean check(TreeNode root,long leftMax,long rightMin)
    {
         if(root==null)
         return true;

         if(root.val<=leftMax || root.val>=rightMin)
         return false;
         
         boolean l=check(root.left,leftMax,root.val);
         boolean r=check(root.right,root.val,rightMin);
         if(l&&r)
         return true;

         return false;
    }

    public boolean isValidBST(TreeNode root) {
        

        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }
}