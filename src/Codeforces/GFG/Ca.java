package Codeforces.GFG;

import java.util.*;


public class Ca {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            assert n>=1 && n<=2*1e5;

            int k = sc.nextInt();
            assert k>=1 && k<=2*1e5;
            long[] a = new long[n];
            long[] b = new long[n];

            for (int i = 0; i < n; i++)
                a[i] = sc.nextLong();
            for (int i = 0; i < n; i++)
                b[i] = sc.nextLong();

            assert a.length==n;
            assert b.length==n;
            for(int i=0;i<n;i++){
                assert a[i]>=1 && a[i]<=1e12;
                assert b[i]>=1 && b[i]<=1e7;
            }
            String s = sc.next();
            if (!canCharge(n, k, a, b, 1000000000000000L)) {
                System.out.println(-1);
                System.out.println("~");
                continue;
            }

            long min = 0;
            long max = 1000000000000000L;
            while (min != max) {
                long mid = (min + max) / 2;
                if (canCharge(n, k, a, b, mid)) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            System.out.println(min);
            System.out.println("~");
        }

    }

    public static boolean canCharge(int n, int k, long[] a, long[] b, long power) {
        long[] ac = a.clone();
        long[] bc = b.clone();
        int tn = 0;
        int[] needed = new int[k];
        for (int i = 0; i < n; i++) {
            while (ac[i] / bc[i] < k - 1) {
                tn++;
                if (tn > k)
                    return false;
                needed[(int) (ac[i] / bc[i])]++;
                ac[i] += power;
            }
        }
        int[] nts = new int[k];
        nts[0] = needed[0];
        for (int i = 1; i < k; i++)
            nts[i] = nts[i - 1] + needed[i];
        for (int i = 0; i < k; i++) {
            if (nts[i] > i + 1)
                return false;
        }
        return true;
    }
}