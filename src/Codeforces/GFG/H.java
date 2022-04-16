package Codeforces.GFG;

import java.util.*;
import java.io.*;

public class H {

    public static void main(String args[]) throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int test= in.nextInt();
        while(test-->0){
        int n=in.nextInt();
        Trie t=new Trie();
        long a[]=new long[n];
        long xor=0;
        for(int i=0;i<n;i++){
            a[i] = in.nextLong();
        }
        String s = in.next();
        for(int i=0;i<n;i++)
            xor^=a[i];
        long ans=xor;
        t.insert(0);

        for(int i=n-1;i>=0;i--)
        {
            xor^=a[i];
            if(i+1!=n)
                a[i]^=a[i+1];
            t.insert(a[i]);
            ans=Math.max(ans,t.maxXor(xor));
            ans=Math.max(ans, a[i]);
        }
        out.println(ans);
        out.println("~");
        out.flush();
        }
    }
    
    static class Trie {

        int N;
        int left[], right[];

        Trie() {
            N = 1;
            left = new int[4000000]; // bits * total numbers
            right = new int[4000000];

        }

        int createNode() {
            N++;
            return N;
        }

        void insert(long value) {
            int node = 1;
            long mask = 1l << 40;
            while (mask > 0) {
                if ((value & mask) > 0) {
                    if (right[node] == 0) {
                        right[node]=createNode();
                    }
                    node = right[node];

                } else {
                    if (left[node] == 0) {
                        left[node]=createNode();
                    }
                    node = left[node];

                }
                mask >>= 1;
            }

        }

        long maxXor(long value) {
            long ans = 0;
            int node = 1;
            long mask = 1l << 40;
            while (mask > 0) {
                if ((mask & value) > 0) {
                    if (left[node] != 0) {
                        ans += mask;
                        node = left[node];
                    } else if (right[node] != 0) {
                        node = right[node];
                    } else {
                        break;
                    }
                } else if (right[node] != 0) {
                    ans += mask;
                    node = right[node];
                } else if (left[node] != 0) {
                    node = left[node];
                } else {
                    break;
                }
                mask>>=1;
            }
            return ans;
        }
    }

}
