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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode ans=new ListNode();
        ListNode temp=new ListNode();
        ans.next=temp;
        int carry=0;
        while(l1!= null && l2!=null)
        {
            int sum=(l1.val+l2.val+carry);
            carry=sum/10;
            ListNode cur=new ListNode(sum%10);
            temp.next=cur;
            temp=cur;
            l1=l1.next;
            l2=l2.next;

        }

        while(l1!=null)
        {
            int sum=(l1.val+carry);
            carry=sum/10;
            ListNode cur=new ListNode(sum%10);
            temp.next=cur;
            temp=cur;
            l1=l1.next;
        }
        while(l2!=null)
        {
            int sum=(l2.val+carry);
            carry=sum/10;
            ListNode cur=new ListNode(sum%10);
            temp.next=cur;
            temp=cur;
            l2=l2.next;
        }
        if(carry==1)
        {
            ListNode cur=new ListNode(carry);
            temp.next=cur;
        }
        return ans.next.next;
    }
}