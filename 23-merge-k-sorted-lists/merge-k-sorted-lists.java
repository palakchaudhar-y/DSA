class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
    for(ListNode head:lists){
        if(head!=null){
            pq.offer(head);
        }
    }    
    ListNode dummy=new ListNode(0);
    ListNode temp=dummy;
    while(!pq.isEmpty()){
        ListNode node=pq.poll();
        temp.next=node;
        temp=temp.next;
        if(node.next!=null){
            pq.offer(node.next);
        }
    }
    return dummy.next;
    }
}