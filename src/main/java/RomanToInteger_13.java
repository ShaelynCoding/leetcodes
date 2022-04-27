import java.util.HashMap;
import java.util.Map;


public class RomanToInteger_13 {
    public int romanToInt(String s) {
        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);

        int len = s.length();
        int res = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='I' && i+1<len && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X')) {
                res+=mapping.get(s.charAt(i+1))-1;
                i++;
            } else if(s.charAt(i)=='X' && i+1<len && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C')) {
                res+=mapping.get(s.charAt(i+1))-10;
                i++;
            } else if(s.charAt(i)=='C' && i+1<len && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M')) {
                res+=mapping.get(s.charAt(i+1))-100;
                i++;
            } else {
                res+=mapping.get(s.charAt(i));
            }

        }
        return res;
    }
}
