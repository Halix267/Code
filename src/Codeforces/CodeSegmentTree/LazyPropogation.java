package Codeforces.CodeSegmentTree;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
// Range update query
public class LazyPropogation{
    public static void main(String[] args) throws Exception {new LazyPropogation().run();}
    long mod = 1000000000 + 7;


    static int N = 100000;

    int[] t = new int[4*N]; // t[x] stores the sum of node x
    int[] lazy = new int[4*N];// tells if a node  is storing unpropogate update or not
    int[] upd = new int[4*N]; // the value of the unpropogate update

    //node v -> 2*v and (2*v+1)

    // tl,tr -> node range(yellow)
    // id -> updating point
    // val -> new value

    void apply(int v,int tl,int tr,int val){

        t[v]+=(val*(tr-tl+1)); //store correct info
        if(tl!=tr){ // v is not a leaf node;

            lazy[v]=1;
            upd[v]+=val;
        }
    }

    void pushdown(int v,int tl,int tr){

        if(lazy[v]==1){ //if it is lazy than propogate it
            lazy[v] =0; //not lazy anymore
            int tm= (tl+tr)/2;
            apply(2*v,tl,tm,upd[v]); //propogate on left child
            apply(2*v+1,tm+1,tr,upd[v]); //propogate on right child
            upd[v]=0; //update done;
        }
    }
    void update(int v,int tl,int tr,int l,int r,int val){

        if(tl>r || tr<l){ // no overlap
            return;
        }

        if(l<=tl && tr<=r) { // fully overlap
            apply(v,tl,tr,val);
            return;
        }

        // partial overlap

        pushdown(v,tl,tr);// remove lazy tag before going down
        //why? So that children have correct values

        int tm = (tl+tr)/2;
        update(2*v,tl,tm,l,r,val);
        update(2*v+1,tm+1,tr,l,r,val);
        t[v] = t[2*v]+t[2*v+1]; // sum of left && right
    }

    //l,r -> query range(purple)
    int query(int v,int tl,int tr,int l,int r){

        //no overlap
        if(tl>r || tr<l) return 0;

        //fully overlap
        if(l<=tl && tr<=r){ // l.....tl.....tr.....r

            return t[v]; //picking it fully
        }

        //partial overlap

        pushdown(v,tl,tr);
        int tm = (tl+tr)/2;
        int ans=0;
        ans+=query(2*v,tl,tm,l,r);
        ans+=query(2*v+1,tm+1,tr,l,r);
        return ans;
    }

    void solve() throws Exception {

        //v,tl,tr -> 1,0,N-1

        update(1,0,N-1,2,5,3);

        out.println(query(1,0,N-1,3,4));



    }




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
