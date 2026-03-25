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
    

    private int ans=0;
    private int find(TreeNode root,long sum,int targetSum)
    {
        if(root==null)
        {
            return 0;
        }
        int cnt=0;
        if(sum==targetSum)
        cnt++;
        int left=0;
        if(root.left!=null)
        left= find(root.left,sum+root.left.val,targetSum);
        int right=0;
        if(root.right!=null)
        right=find(root.right,sum+root.right.val,targetSum);

        return cnt+ left+right;
    }
    private void check(TreeNode root,int targetSum)
    {
        if(root==null)return;
        check(root.left,targetSum);
        check(root.right,targetSum);
        int take=find(root,root.val,targetSum);
        ans+=take;

    }

    public int pathSum(TreeNode root, int targetSum) {
        
        check(root,targetSum);
        return ans;
    }
}