package utils;

public class ListNode {
    public ListNode next;
    public int val;

    ListNode(){}
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }

    public static void printList(ListNode head){
        ListNode first = head;
        while(first!=null){
            System.out.print(first.val+" -> ");
            first=first.next;
        }
        System.out.print(" null");
    }

    public static ListNode insert(ListNode head,int item){
        ListNode temp = new ListNode();
        ListNode ptr;

        temp.val = item;
        temp.next =null;

        if(head==null){
            head=temp;
        }else{
            ptr = head;
            while (ptr.next!=null)
                ptr=ptr.next;

            ptr.next=temp;
        }

        return head;

        }

        public static ListNode arrayToList(int[] arr,int n){
        ListNode root =null;
        for(int i=0;i<n;i++){
            root=insert(root,arr[i]);
        }
        return root;
        }
    }

