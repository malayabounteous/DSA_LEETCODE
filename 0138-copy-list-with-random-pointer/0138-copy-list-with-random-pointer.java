/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Map<Node,Node>randomMap=new HashMap<>();
        Map<Node,Node>copy=new HashMap<>();
        Map<Node,Node>revCopy=new HashMap<>();
        
        Node temp=new Node(0);
        Node ans=new Node(0);
        
        temp.next=ans;
        
        while(head!=null)
        {
            Node cur=new Node(head.val);
            ans.next=cur;
            ans=cur;
            randomMap.put(head,head.random);
            copy.put(cur,head);
            revCopy.put(head,cur);
            head=head.next;
        }
        ans=temp.next.next;
        while(temp!=null)
        {
           Node origNode=copy.get(temp);
           Node rand=randomMap.get(origNode);
           Node curRand=revCopy.get(rand);
           temp.random=curRand;
           temp=temp.next;
        }

        return ans;


    }
}