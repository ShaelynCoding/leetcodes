import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class IsValid_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int len = s.length();
        int index = 0;
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        while(index < len) {
            Character c = s.charAt(index);
            if(map.keySet().contains(c)) {
                stack.push(c);
                index++;
            } else {
                if(stack.empty()) return false;
                Character cur = stack.pop();
                if(map.get(cur) == c) {
                    index++;
                } else {
                    return false;
                }
            }
        }
        if(!stack.empty()) return false;
        return true;
    }

}
