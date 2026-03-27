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
    public ListNode swapPairs(ListNode head) {
        
        ListNode ans=new ListNode();
        ListNode temp=ans;
        while(head!=null && head.next!=null)
        {
           ListNode nextHead=head.next.next;
           ListNode cur=head;
           temp.next=head.next;
           head.next.next=cur;
           temp=cur;
           head=nextHead;

        }
        temp.next=head;
        return ans.next;
    }
}