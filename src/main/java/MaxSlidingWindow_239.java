import java.nio.DoubleBuffer;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class MaxSlidingWindow_239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        int[] res = {};
        if(len == 0 || len < k) {
            return res ;
        }
        res = new int[len-k+1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<Integer>();
        while(index<len) {
            while(deque.size()!=0 && nums[index] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(index);
            int first = deque.peekFirst();
            if(first<index-k+1) {
                deque.pollFirst();
            }
            if(index>=k-1) {
                res[index-k+1] = nums[deque.peekFirst()];
            }
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,-1};
        int[] res = maxSlidingWindow(nums, 1);
        System.out.print("{1,3,-1,-3,5,3,6,7}: ");
        print(res);
    }

    private static void print(int[] res) {
        for(int r : res) {
            System.out.print(r);
        }
    }
}
