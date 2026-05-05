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
    public ListNode rotateRight(ListNode head, int k) {
        
        ListNode temp=head;
        if(head==null || head.next==null)return head;
        int size=0;
        ListNode prev=null;
        while(temp!=null)
        {
            size++;
            prev=temp;
            temp=temp.next;
        }
        k=k%size;
        prev.next=head;
        temp=head;
        int x=size-k;
         prev=null;
        while(x!=0)
        {
            prev=temp;
            temp=temp.next;
            x--;
        }
        prev.next=null;
        return temp;
    }
}