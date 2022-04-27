import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class SubstringWithConcatenationOfAllWords_30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<Integer>();
        int size = words.length;
        int wordLen = words[0].length();
        if(size==0) return res;
        Map<String, Integer> wordNums = new HashMap<String, Integer>();
        for(String word: words) {
            Integer c = wordNums.getOrDefault(word,0);
            wordNums.put(word, c+1);
        }
        for(int i=0;i<=s.length()-wordLen*words.length;i++) {
            Map<String, Integer> tmp = new HashMap<>(wordNums);
            if(dfs(s, i,words, tmp,0)) {
                res.add(i);
            }
        }
        return res;
    }
    public static boolean dfs(String s, int index, String[] words, Map<String, Integer>wordMap, int count) {
        int wordLen = words[0].length();
        if(count==words.length) {
            return true;
        }
        if(index>=s.length() || index+wordLen>s.length()) {
            return false;
        }
        String cur = s.substring(index, index+wordLen);
        Integer remain = wordMap.getOrDefault(cur, 0);
        if(remain!=0) {
            wordMap.put(cur, remain-1);
            if(dfs(s, index+wordLen, words, wordMap, count+1)) return true;
            wordMap.put(cur, remain);
        }
        return false;
    }

    public static List<Integer> findSubstring_map(String s, String[] words) {
        List<Integer> res = new LinkedList<Integer>();
        int size = words.length;
        int wordLen = words[0].length();
        if(size==0) return res;
        Map<String, Integer> wordNums = new HashMap<String, Integer>();
        for(String word: words) {
            Integer c = wordNums.getOrDefault(word,0);
            wordNums.put(word, c+1);
        }
        for(int i=0;i<=s.length()-wordLen*words.length;i++) {
            String curStr = s.substring(i, i+wordLen*words.length);
            Map<String, Integer> tmp = new HashMap<>();
            for (int j = 0; j < curStr.length(); j += wordLen) {
                String cur = curStr.substring(j, j + wordLen);
                tmp.put(cur, tmp.getOrDefault(cur, 0) + 1);
            }
            if (tmp.equals(wordNums))
                res.add(i);
        }
        return res;

    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        printRes(findSubstring_map(s, words));
        s = "wordgoodgoodgoodbestword";
        String[] words2 = {"word","good","best","word"};
        printRes(findSubstring(s, words2));
        s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words3 = {"fooo","barr","wing","ding","wing"};
        printRes(findSubstring(s, words3));
        s = "wordgoodgoodgoodbestword";
        String[] words4 = {"word","good","best","good"};
        printRes(findSubstring(s, words4));

    }

    private static void printRes(List<Integer> list) {
        for(Integer i:list) {
            System.out.print(i+" ");
        }
        System.out.println(" ");
    }
}
