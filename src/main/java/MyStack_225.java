import java.util.LinkedList;
import java.util.Queue;


public class MyStack_225 {
    class MyStack {
        private Queue<Integer> first;
        private Queue<Integer> second;

        public MyStack() {
            first = new LinkedList<Integer>();
            second = new LinkedList<Integer>();
        }

        public void push(int x) {
            if(!first.isEmpty()) {
                first.add(x);
            } else {
                second.add(x);
            }
        }

        public int pop() {
            if(first.isEmpty()) {
                while(second.size()>1) {
                    Integer i = second.poll();
                    first.add(i);
                }
                return second.poll();
            }
            while(first.size()>1) {
                Integer i = first.poll();
                second.add(i);
            }
            return first.poll();
        }


        public int top() {
            if(first.isEmpty()) {
                while(second.size()>1) {
                    Integer i = second.poll();
                    first.add(i);
                }
                Integer last = second.poll();
                first.add(last);
                return last;
            }
            while(first.size()>1) {
                Integer i = first.poll();
                second.add(i);
            }
            Integer last = first.poll();
            second.add(last);
            return last;
        }

        public boolean empty() {
            return first.isEmpty() && second.isEmpty();
        }
    }

}
