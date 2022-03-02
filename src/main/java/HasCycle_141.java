import java.util.HashSet;
import java.util.Set;


public class HasCycle_141 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static boolean hasCycleHashSet(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while(head!=null) {
            if(set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    public static boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=slow) {
            if(fast==null || fast.next==null) return false;
            fast = fast.next.next;
            if(slow==null) return false;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
