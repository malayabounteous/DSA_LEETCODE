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
    public List<List<Integer>> levelOrder(TreeNode root) {
          



        List<List<Integer>>ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)
        return ans;
        q.add(root);

        while(!q.isEmpty())
        {
           List<Integer>list=new ArrayList<>();
           int n=q.size();
           while(n>0)
           {
            TreeNode t=q.poll();
            list.add(t.val);
            if(t.left!=null)
            q.offer(t.left);
            if(t.right!=null)
            q.offer(t.right);
            n--;
           }
           ans.add(list);

        }
        return ans;
    }
}