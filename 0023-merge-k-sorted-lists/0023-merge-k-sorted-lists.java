/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode mergeTwo(ListNode head1,ListNode head2)
    {

        ListNode ans=new ListNode();
        ListNode temp=ans;
        while(head1!=null && head2!=null)
        {
            if(head1.val<=head2.val)
            {
              ans.next=head1;
              head1=head1.next;
            }
            else
            {
                ans.next=head2;
                head2=head2.next;
            }
            ans=ans.next;
        }
        if(head1!=null)
        ans.next=head1;
        if(head2!=null)
        ans.next=head2;

        return temp.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode head=new ListNode();

        ListNode temp=head;
        int n=lists.length;
        if(n==0)return null;
        if(n==1)return lists[0];

        temp=lists[0];
        for(int i=1;i<n;++i)
        {
           temp=mergeTwo(temp,lists[i]);
        }

        return temp;
    }
}