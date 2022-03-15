public class CountingBits_338 {
    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=0;i<=n;i++) {
            int count = 0;
            int cur = i;
            while(cur!=0) {
                count++;
                cur=cur&(cur-1);
            }
            res[i]=count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print("2: ");
        print(countBits(2));
    }

    private static void print(int[] res) {
        for(int r:res) {
            System.out.print(r+" ");
        }
    }
}
