public class CountAndSay_38 {
    public static String countAndSay(int n) {
        if(n==1) return "1";
        String prev = countAndSay(n-1);
        StringBuilder builder = new StringBuilder();
        int i=0;
        while (i<prev.length()) {
            int count=1;
            Character curChar = prev.charAt(i);
            int j=i+1;
            while(j<prev.length() && prev.charAt(j)==curChar) {
                count++;
                j++;
            }
            builder.append(count);
            builder.append(curChar);
            i=j;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }


}
