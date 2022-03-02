import java.util.HashMap;
import java.util.Map;


public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {
        return calculate(s).equals(calculate(t));
    }
    private Map<Character, Integer> calculate(String s) {
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }
            else {
                map.put(c,0);
            }

        }
        return map;
    }
}
