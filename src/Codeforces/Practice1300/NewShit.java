package Codeforces.Practice1300;



import java.io.*;
import java.util.*;

public class NewShit {
    public static void main(String[] args) throws Exception {new NewShit().run();}
    long mod = 1000000000 + 7;

    // int[][] dp= new int[32][200001];

    // int[][] ar;
    int ans=0;
    void solve() throws Exception {

        int t=ni();

        while(t-->0){

            int n = ni();
            int k =ni();
            int[] a = new int[n+k-1];
            for(int i=0;i<n;i++){
                a[i] =ni();
            }

            int cnt=n;
            int total  = 0;
            for(int i:a) total+=i;
            boolean[] vis = new boolean[n];
            while(cnt>k){

                int l=0,r=0,max = Integer.MAX_VALUE,sum=0,ind1=0,ind2=0;

                while(r<n+k-1) {
                    if (!vis[r % n]) {
                        sum += a[r % n];
                        if (r - l + 1 < k) {
                            r++;
                            continue;
                        }

                        if (r - l + 1 == k) {
                            if (sum > max) {
                                ind1 = l;
                                ind2 = r;
                                max = sum;

                            }
                            sum -= a[l];
                            l++;
                            r++;
                        }
                    }
                    else r++;
                }
                for(int i=ind1;i<=ind2;i++){
                    vis[i%n] = true;
                }
                for(int i=0;i<n;i++){
                    out.print(vis[i]+" ");
                }
                out.println();
                cnt-=k;
            }

//            for(int i=0;i<n+k-1;i++){
//                out.print(a[i]+" ");
//            }
//            out.println();



        }

    }
    void FindAns(List<Integer> l,int n,int k,int p){

        if(p>=n) return;
        out.println(l);
        int left=0;
        int right=0;
        int sum=0;
        int max= Integer.MIN_VALUE;
        int ind1=-1;
        int ind2=-1;
        int total =0;
        for(int i=0;i<n-p;i++)total+=l.get(i);
        ans+=(total-sum);
        while(right<n+k-1-p){
            sum+=l.get(right%n);
            if(right-left+1<k){

                right++;
                continue;
            }
            //  out.println("right and sum: "+right+" "+sum);
            if(right-left+1==k){
                //out.println("sum: "+sum);
                if(sum>max){
                    ind1 =left%n;
                    ind2 =right%n;
                    max= sum;
                }
                sum-=l.get(left);
                left++;
                right++;
            }
        }


        l.subList(ind1,ind2+1).clear();
        FindAns(l,n,k,p+k);
    }

    int[] sort(int[] a){
        List<Integer> l= new ArrayList<>();
        for(int i:a) l.add(i);
        int[] res = new int[l.size()];

        for(int i=0;i<l.size();i++){
            res[i] =  l.get(i);
        }
        return res;
    }


    // void buildMatrix(){
    //
    // for(int i=1;i<=1000;i++){
    //
    // ar[i][1] = (i*(i+1))/2;
    //
    // for(int j=2;j<=1000;j++){
    // ar[i][j] = ar[i][j-1]+(j-1)+i-1;
    // }
    // }
    // }

    /* FAST INPUT OUTPUT & METHODS BELOW */

    private byte[] buf = new byte[1024];
    private int index;
    private InputStream in;
    private int total;
    private SpaceCharFilter filter;
    PrintWriter out;

    int min(int... ar) {
        int min = Integer.MAX_VALUE;
        for (int i : ar)
            min = Math.min(min, i);
        return min;
    }

    long min(long... ar) {
        long min = Long.MAX_VALUE;
        for (long i : ar)
            min = Math.min(min, i);
        return min;
    }

    int max(int... ar) {
        int max = Integer.MIN_VALUE;
        for (int i : ar)
            max = Math.max(max, i);
        return max;
    }

    long max(long... ar) {
        long max = Long.MIN_VALUE;
        for (long i : ar)
            max = Math.max(max, i);
        return max;
    }

    void shuffle(int a[]) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            al.add(a[i]);

        Collections.sort(al);
        for (int i = 0; i < a.length; i++)
            a[i] = al.get(i);
    }

    long lcm(long a, long b) {
        return (a * b) / (gcd(a, b));
    }

    int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    /*
     * for (1/a)%mod = ( a^(mod-2) )%mod ----> use expo to calc -->(a^(mod-2))
     */
    long expo(long p, long q) /* (p^q)%mod */
    {
        long z = 1;
        while (q > 0) {
            if (q % 2 == 1) {
                z = (z * p) % mod;
            }
            p = (p * p) % mod;
            q >>= 1;
        }
        return z;
    }

    void run() throws Exception {
        in = System.in;
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }

    private int scan() throws IOException {
        if (total < 0)
            throw new InputMismatchException();
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0)
                return -1;
        }
        return buf[index++];
    }

    private int ni() throws IOException {
        int c = scan();
        while (isSpaceChar(c))
            c = scan();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = scan();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = scan();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    private long nl() throws IOException {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = scan()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = scan();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = scan();
        }
    }

    private double nd() throws IOException {
        return Double.parseDouble(ns());
    }

    private String ns() throws IOException {
        int c = scan();
        while (isSpaceChar(c))
            c = scan();
        StringBuilder res = new StringBuilder();
        do {
            if (Character.isValidCodePoint(c))
                res.appendCodePoint(c);
            c = scan();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    private String nss() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    private char nc() throws IOException {
        int c = scan();
        while (isSpaceChar(c))
            c = scan();
        return (char) c;
    }

    private boolean isWhiteSpace(int n) {
        if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
            return true;
        return false;
    }

    private boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhiteSpace(c);
    }

    private interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
