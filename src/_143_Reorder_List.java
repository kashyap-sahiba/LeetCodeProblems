import utils.ListNode;

public class _143_Reorder_List {

    public static void reorderList(ListNode head){

        ListNode slow = head;
        ListNode fast = slow.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }

        ListNode second =slow.next;
        ListNode prev = slow.next = null;

        while(second!=null){
            ListNode temp =second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode first = head;
        second = prev;

        while(second!=null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next=second;
            second.next =temp1;
            first=temp1;
            second=temp2;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4};
        ListNode head = ListNode.arrayToList(arr,arr.length);
        reorderList(head);
        ListNode.printList(head);
    }

}
