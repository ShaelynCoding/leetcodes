public class LongestPalindrome_5 {
    public static String longestPalindromeCentral(String s) {
        int len = s.length();
        int max = 0;
        String res = "";
        for(int i=0;i<len;i++) {
            int right = i;
            int left = i;
            while(left>=0 && s.charAt(left) == s.charAt(i)) {
                left --;
            }
            while(right<len && s.charAt(i) == s.charAt(right)) {
                right ++;
            }
            while (left>=0 && right<len && s.charAt(left) == s.charAt(right)) {
                left --;
                right ++;
            }
            left ++;right --;
            if(right - left + 1 > max) {
                max = right - left + 1;
                res = s.substring(left, right+1);
            }
        }
        return res;
    }

    public static String longestPalindromeDP(String s) {
        int len = s.length();
        int max = 1;
        int start = 0;
        boolean[][] dp = new boolean[len][len];
        for(int r=1;r<len;r++) {
            for(int l=0;l<r;l++) {
                dp[l][r]= (r - l <= 2 || dp[l+1][r-1]) && s.charAt(l)==s.charAt(r);
                if(dp[l][r]) {
                    if(r-l+1 > max) {
                        max = r-l+1;
                        start = l;
                    }
                }
            }
        }
        return s.substring(start, start+max);
    }

    public static void main(String[] args) {
        System.out.println("babad: "+ longestPalindromeCentral("babad"));
        System.out.println("cbbd: "+ longestPalindromeCentral("cbbd"));
        System.out.println("ac: "+ longestPalindromeCentral("ac"));
        System.out.println("a: "+ longestPalindromeCentral("a"));
        System.out.println("***************Slide Window*********************");
        System.out.println("babad: "+ longestPalindromeDP("babad"));
        System.out.println("cbbd: "+ longestPalindromeDP("cbbd"));
        System.out.println("ac: "+ longestPalindromeDP("ac"));
        System.out.println("aaaa: "+ longestPalindromeDP("aaaa"));
    }

}
