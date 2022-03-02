public class ReverseList_206 {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(head!=null) {
            head = head.next;
            cur.next = prev;
            prev = cur;
            cur = head;

        }
        return prev;
    }

    public static ListNode reverse(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = reverse(node1);
        print(node);

    }


    private static void print(ListNode node) {
        while(node!=null) {
            System.out.print(node.val);
            System.out.print(" ");
            node = node.next;
        }
    }
}
