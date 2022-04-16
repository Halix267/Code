package Codeforces.CONTEST.Round761;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ForbiddnSeq {
    public static void main(String[] args) throws Exception {new ForbiddnSeq ().run();}
    long mod = 1000000000 + 7;

    int ans=0;
    // int[][] ar;
    void solve() throws Exception {

        int tt=ni();
        while(tt-->0){
            //int n = ni();

            String s = ns();
            String t = ns();

            Map<Character,Integer> map = new TreeMap<>();
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            s = new String(ch);
            for(char c:s.toCharArray()){
                map.put(c,map.getOrDefault(c,0)+1);
            }

            StringBuilder ans = new StringBuilder();
            int n= s.length();
            int m = t.length();
            boolean found = true;
            for(int i=0;i<m;i++){

                char c = t.charAt(i);
                if(!map.containsKey(c)){
                    found = false;
                }
            }
            if(!found){

                out.println(new String(ch));
                continue;
            }else{

                if(isSub(s,t)){
                    //out.println("GGGGG");
                    char a1='b';
                    char a2 = 'c';

                    if(t.charAt(1)=='b' && t.charAt(2)=='c'){
                        //out.println("GG");
                        int cnt = map.get('a');
                        for(int i=0;i<cnt;i++){
                            ans.append('a');
                        }
                        cnt = map.get('c');
                        for(int i=0;i<cnt;i++){
                            ans.append('c');
                        }
                        cnt = map.get('b');
                        for(int i=0;i<cnt;i++){
                            ans.append('b');
                        }
                      //  out.println(ans+" "+"1212");
                        for(char i:map.keySet()){
                            if((i=='a') || (i=='b') || (i=='c')) continue;{
                               // out.println(i);
                                int g = map.get(i);
                                for(int j=0;j<g;j++){
                                    ans.append(i);
                                }
                            }
                        }
                       // out.println(ans+" "+"dsf");
                        out.println(ans);

                    }else if(t.charAt(1)=='c' && t.charAt(2)=='b'){
                        int cnt = map.get('a');
                        for(int i=0;i<cnt;i++){
                            ans.append('a');
                        }
                        cnt = map.get('b');
                        for(int i=0;i<cnt;i++){
                            ans.append('b');
                        }
                        cnt = map.get('c');
                        for(int i=0;i<cnt;i++){
                            ans.append('c');
                        }

                        for(char i:map.keySet()){
                            if((i=='a') || (i=='b') || (i=='c')) continue;{
                                int g = map.get(i);
                                for(int j=0;j<g;j++){
                                    ans.append(i);
                                }
                            }
                        }
                       // out.println("AS");
                        out.println(ans);
                    }else out.println(s);

                }else{

                    out.println(s);
                }
            }



        }




    }

    boolean isSub(String s,String t){
        int i=0;
        int j=0;
        int n = s.length();
        while(i<n){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }

            if(j==t.length()) return true;
        }
        return false;
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
