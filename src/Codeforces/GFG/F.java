package Codeforces.GFG;
import java.util.*;

public class F {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        assert t>=1 && t<=1000;
        while(t-->0){
            int n = in.nextInt();
            assert n>=1 && n<=1e5;
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
                assert ar[i]>=0 && ar[i]<=1e9;
            }
            String s = in.next();
            Arrays.sort(ar);
            System.out.println(cal(30, 0, n - 1, ar));
            System.out.println("~");
        }



    }

    static int cal(int index, int from, int to, int[] data) {
        if (index < 0) {
            return 0;
        }
        if (from > to) {
            return 0;
        }
        int re = -1;
        int st = from;
        int ed = to;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if ((data[mid] & (1 << index)) != 0) {
                re = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        if (re != -1 && re != from) {

            int a = (1 << index) + cal(index - 1, from, re - 1, data);
            int b = (1 << index) + cal(index - 1, re, to, data);
            return Integer.min(a, b);

        } else {
            return cal(index - 1, from, to, data);
        }
    }
}
