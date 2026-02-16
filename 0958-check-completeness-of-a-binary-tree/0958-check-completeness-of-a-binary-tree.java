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
   class Pair{
    int index;
    TreeNode node;
    public Pair(TreeNode n,int i )
    {
        node=n;
        index=i;
    }
   }
    public boolean isCompleteTree(TreeNode root) {
        

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int ind=-1;
        while(!q.isEmpty())
        {
            
            int n=q.size();
            while(n!=0)
            {
                Pair cur=q.poll();
                if(ind!=cur.index-1)
                return false;
                
                if(cur.node.left!=null )
                {
                    q.add(new Pair(cur.node.left,cur.index*2 +1));
                }
                if( cur.node.right!=null)
                {
                    if(cur.node.left==null )
                    return false;
                    q.add(new Pair(cur.node.right,cur.index*2 +2));
                }
                n--;
               // prev=cur;
                ind=cur.index;
            }
        }
        return true;

    }
}