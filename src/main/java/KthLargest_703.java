import java.util.PriorityQueue;


public class KthLargest_703 {
    class KthLargest {
        private int k;
        private PriorityQueue<Integer> priorityQueue;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            priorityQueue = new PriorityQueue<Integer>();
            for(int i : nums) {
                add(i);
            }
        }

        public int add(int val) {
            if (priorityQueue.size()<k) {
                priorityQueue.add(val);
            } else if(priorityQueue.peek()<val) {
                priorityQueue.poll();
                priorityQueue.add(val);
            }
            return priorityQueue.peek();
        }
    }
}
