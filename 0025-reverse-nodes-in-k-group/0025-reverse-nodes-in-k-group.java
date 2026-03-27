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

    private ListNode reverse(ListNode head)
    {
        ListNode cur=head;
        ListNode prev=null;
        while(cur!=null)
        {
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
       ListNode temp=head;
       int len=0;
       while(temp!=null)
       {
        len++;
        temp=temp.next;
       }
       k=k%len;
       if(k==0)return reverse(head);      
      ListNode ans=new ListNode();
       temp=ans;
      while(head!=null)
      {
          int x=k;
          ListNode cur=head;
          ListNode prev=head;
          while(x!=0 && head!=null)
          {
            prev=head;
            head=head.next;
            x--;
          }
          if(x!=0)
          {
            temp.next=cur;
            break;
          }
          prev.next=null;
        //   ListNode newHead=head;
        //   head=null;
          ListNode t1=cur;
          temp.next=reverse(cur);
          temp=t1;

      }
      return ans.next;


    }
}