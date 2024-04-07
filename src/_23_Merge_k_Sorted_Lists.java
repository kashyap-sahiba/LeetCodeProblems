import utils.ListNode;

import java.util.PriorityQueue;

public class _23_Merge_k_Sorted_Lists {
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists==null || lists.length==0){
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val- b.val);

        for(ListNode node : lists){
            if(node!=null){
                minHeap.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!minHeap.isEmpty()){
            ListNode smallest = minHeap.poll();
            tail.next = smallest;
            tail = tail.next;

            if(smallest.next!=null){
                minHeap.add(smallest.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        ListNode merged = mergeKLists(lists);

        while(merged!=null){
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
