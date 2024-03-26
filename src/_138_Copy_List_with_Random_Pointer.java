public class _138_Copy_List_with_Random_Pointer {
    static class Node{
        int val;
        Node next;
        Node random;

        Node(int val){
            this.val=val;
            this.next=null;
            this.random=null;
        }
    }
    public static Node copyRandomList(Node head){
        Node curr = head;

        while(curr!=null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next=newNode;
            curr=newNode.next;
        }

        curr=head;

        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }

        Node dummy = new Node(0);
        Node newHead = dummy;
        curr = head;

        while(curr!=null){
            Node newNode =curr.next;
            dummy.next=newNode;
            dummy=newNode;

            curr.next=newNode.next;
            curr=curr.next;
        }

        return newHead.next;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        head.random=head.next.next;
        head.next.random=head;
        head.next.next.random=head.next;

        Node copiedList = copyRandomList(head);

        System.out.println("Original List");
        printList(head);
        System.out.println("Copied List");
        printList(copiedList);

    }

    private static void printList(Node head) {
        Node current = head;
        while (current!=null){
            System.out.print("("+current.val+", ");
            if(current.random!=null){
                System.out.print(current.random.val);
            }else {
                System.out.print("null");
            }
            System.out.print(") -> ");
            current=current.next;
        }

        System.out.println("null");

    }
}
