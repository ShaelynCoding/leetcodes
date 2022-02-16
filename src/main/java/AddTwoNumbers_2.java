import java.util.List;


public class AddTwoNumbers_2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int remain = sum/10;
        ListNode prev = new ListNode();
        prev.val = sum % 10;
        ListNode first = prev;
        while(l1.next!=null && l2.next!=null) {
            l1 = l1.next; l2 = l2.next;
            sum = l1.val + l2.val + remain;
            remain = sum/10;
            ListNode node = new ListNode();
            node.val = sum % 10;
            prev.next = node;
            prev = node;
        }
        while(l1.next!=null) {
            l1 = l1.next;
            sum = l1.val+remain;
            remain = sum/10;
            ListNode node = new ListNode();
            node.val = sum % 10;
            prev.next = node;
            prev = node;
        }
        while(l2.next!=null) {
            l2 = l2.next;
            sum = l2.val+remain;
            remain = sum/10;
            ListNode node = new ListNode();
            node.val = sum % 10;
            prev.next = node;
            prev = node;
        }
        if(remain!=0) {
            ListNode node = new ListNode();
            node.val = remain;
            prev.next = node;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode left_4 = new ListNode(9,null);
        ListNode left_3 = new ListNode(9,left_4);
        ListNode left_2 = new ListNode(9,left_3);
        ListNode left_1 = new ListNode(9,left_2);

        ListNode right_3 = new ListNode(9,null);
        ListNode right_2 = new ListNode(9,right_3);
        ListNode right_1 = new ListNode(9,right_2);

        ListNode res = addTwoNumbers(left_1, right_1);
        while(res!=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
