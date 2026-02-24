/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
int totsum=0;
void helper(TreeNode* root,int sum)
{
    if(!root)
    return ;
    sum=sum*2 +root->val;
    if(root->left==NULL && root->right==NULL)
    {
        totsum+=sum;
        return;
    }
    helper(root->left,sum);
    helper(root->right,sum);
    return;
}
    int sumRootToLeaf(TreeNode* root) {
        
        helper(root,0);
        return totsum;
    }
};