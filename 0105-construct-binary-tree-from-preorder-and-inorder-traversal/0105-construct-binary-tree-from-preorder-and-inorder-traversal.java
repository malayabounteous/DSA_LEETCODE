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
   int find(int x,int[]inorder)
   {
    int n=inorder.length;
    for(int i=0;i<n;++i)
    {
        if(inorder[i]==x)
        return i;
    }
    return -1;
   }
   public TreeNode generate(int preStart,int preEnd,int inStart,int inEnd,int[] preorder, int[] inorder)
   {
       if( inStart>inEnd || preStart>preEnd)
       return null;
        
       TreeNode root=new TreeNode(preorder[preStart]);
       int ind=find(preorder[preStart],inorder);

       int left=ind-inStart;
       root.left=generate(preStart+1,preStart+left,inStart,ind-1,preorder,inorder);
       root.right=generate(preStart+left+1,preEnd,ind+1,inEnd,preorder,inorder);

       return root;
   }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        return generate(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }
}