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
 class NodeVal{
    int min;
    int max;
    
    int sum;
    public NodeVal(int min,int max,int sum)
    {
        this.min=min;
        this.max=max;
        this.sum=sum;
    }
 }
class Solution {
   int ans=0;
    NodeVal helper(TreeNode root)
    {
        if(root==null)
        return new NodeVal(Integer.MAX_VALUE,Integer.MIN_VALUE,0);

        NodeVal l=helper(root.left);
        NodeVal r=helper(root.right);

        if(root.val>l.max && root.val<r.min)
        {
            ans=Math.max(ans,l.sum+r.sum+root.val);
            return new NodeVal(Math.min(root.val,l.min),Math.max(root.val,r.max),l.sum+r.sum+root.val);
        }
        ans=Math.max(ans,Math.max(l.sum,r.sum));
        return new NodeVal(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(r.sum,l.sum));
       
    }
    public int maxSumBST(TreeNode root) {
        
        helper(root);
        
        
        return ans;
    }
}