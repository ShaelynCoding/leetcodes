import java.util.HashMap;
import java.util.Map;


public class IntToRoman_12 {
    public static String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        String res = "";
        int remain = num;
        int div = 10;
        int cur = num;
        while(remain !=0) {
            cur = remain%10;
            remain = remain/10;

            if(cur == 4) {
                res = map.get(div/10)+map.get(5*div/10)+res;
            } else if(cur==9) {
                res = map.get(div/10)+map.get(div)+res;
            } else if (cur==5) {
                res = map.get(5*div/10)+res;
            } else {
                String tmp = "";
                if(cur>5) {
                   tmp+=map.get(5*div/10);
                   cur-=5;
                }
                for(int i=0;i<cur;i++)
                    tmp +=map.get(div/10);
                res = tmp + res;
            }
            div *=10;

        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println("3: "+ intToRoman(3));
        System.out.println("4: "+ intToRoman(4));
        System.out.println("9: "+ intToRoman(9));
        System.out.println("58: "+ intToRoman(58));
        System.out.println("1994: "+ intToRoman(1994));
    }
}
