import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class LengthOfLongestSubstring_3 {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int longest = 0;
        for(int i=0;i<len;i++) {
            Set<Character> set = new HashSet<Character>();
            set.add(s.charAt(i));
            for(int j=i+1;j<len;j++) {
                Character c = s.charAt(j);
                if (!set.contains(c)) {
                    set.add(c);
                } else {
                    break;
                }
            }
            if(set.size() > longest) {
                longest = set.size();
            }
        }
        return longest;
    }

    public static int slideWindowsLongestSubstring(String s) {
        int len = s.length();
        int start = 0;
        int end = 0;
        int ans = 0;
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        while(start<=end && end<len) {
            Character current = s.charAt(end);
            if (map.containsKey(current)) {
                start = Math.max(start, map.get(current));
            }
            map.put(current, end+1);
            ans = Math.max(ans, end-start+1);
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("abcabcbb: "+ lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb: "+ lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew: "+ lengthOfLongestSubstring("pwwkew"));
        System.out.println(" : "+ lengthOfLongestSubstring(" "));
        System.out.println("***************Slide Window*********************");
        System.out.println("abcabcbb: "+ slideWindowsLongestSubstring("abcabcbb"));
        System.out.println("bbbbb: "+ slideWindowsLongestSubstring("bbbbb"));
        System.out.println("pwwkew: "+ slideWindowsLongestSubstring("pwwkew"));
        System.out.println(" : "+ slideWindowsLongestSubstring(" "));
    }
}
