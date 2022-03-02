import java.util.Stack;


public class MyQueue_232 {
    class MyQueue {
        private Stack<Integer> input;
        private Stack<Integer> output;

        public MyQueue() {
            input=new Stack<Integer>();
            output=new Stack<Integer>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            if(!output.isEmpty()) {
                return output.pop();
            }
            while(!input.isEmpty()) {
                Integer i = input.pop();
                output.push(i);
            }
//            if(output.isEmpty()) return null;
            return output.pop();
        }

        public int peek() {
            if(!output.isEmpty()) {
                return output.peek();
            }
            while(!input.isEmpty()) {
                Integer i = input.pop();
                output.push(i);
            }
            return output.peek();
        }


        public boolean empty() {
            if(!output.isEmpty()) {
                return false;
            }
            while(!input.isEmpty()) {
                Integer i = input.pop();
                output.push(i);
            }
            return !output.isEmpty();
        }
    }
}
