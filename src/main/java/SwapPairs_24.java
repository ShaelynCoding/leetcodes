public class SwapPairs_24 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode newhead = head.next;
        ListNode left = head;
        ListNode right = head.next;
        while(left!=null && right!=null && left!=right) {
            ListNode nextHead = right.next;
            if(nextHead!=null && nextHead.next!=null) {
                nextHead = nextHead.next;
            }
            left.next=nextHead;
            ListNode tmp = left;
            left = right.next;
            right.next=tmp;
            right=nextHead;
        }
        return newhead;
    }
    public static ListNode swapPairsRecursion(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }


    public static void main(String[] args) {
//        ListNode node5 = new ListNode(5);
//        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = swapPairs(node1);
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
