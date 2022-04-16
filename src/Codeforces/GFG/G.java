
package Codeforces.GFG;
import java.io.*;
import java.util.*;

public class G {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        assert t>=1 && t<=1000;
        Trie tree = new Trie() ;
        while(t-->0){

            int n = in.nextInt() ;
            assert n>=1 && n<=1e6;
            int k = in.nextInt() ;
            assert k>=1 && k<=1e9;
            long res = 0 ;
            tree.clear() ;
            tree.add(0) ;
            int now = 0 ;
            for(int i = 0 ; i < n ; i++){
                int lp = in.nextInt();
                assert lp>=0 && lp<=1e9;
                now ^= lp;
                res += tree.find(now , k) ;
                tree.add(now) ;
            }
            String s = in.next();
            out.println(res) ;
            out.println("~");
            out.flush() ;
        }

    }

    static class Trie{

        final int NODESIZE = 1000001*30 ;
        final int NULL = 0 ;
        int root ;
        int totel ;
        int[][] next = new int[2][NODESIZE] ;
        int[] cnt = new int[NODESIZE] ;

        int newNode(){
            next[0][totel] = next[1][totel] = NULL ;
            cnt[totel] = 0 ;
            return totel++ ;
        }

        void clear(){
            totel = 0 ;
            root = newNode() ;
        }

        void add(int x){
            int now = root ;
            for(int i = 30 ; i >= 0 ; i--){
                int son = ( x & (1<<i) ) > 0 ? 1 : 0 ;
                if(next[son][now] == NULL)
                    next[son][now] = newNode() ;
                now = next[son][now] ;
                cnt[now]++ ;
            }
        }

        int find(int x , int k){
            int res = 0 ;
            int now = root ;
            for(int i = 30 ; i >= 0 ; i--){
                int bitX = ( x & (1<<i) ) > 0 ? 1 : 0 ;
                int bitK = ( k & (1<<i) ) > 0 ? 1 : 0 ;
                if(bitX == 1 && bitK == 1){
                    if(next[0][now] == NULL) return res ;
                    else now = next[0][now] ;
                }
                else if(bitX == 0 && bitK == 1){
                    if(next[1][now] == NULL) return res ;
                    else now = next[1][now] ;
                }
                else if(bitX == 1 && bitK == 0){
                    if(next[0][now] != NULL) res += cnt[next[0][now]] ;
                    if(next[1][now] == NULL) return res ;
                    else now = next[1][now] ;
                }
                else if(bitX == 0 && bitK == 0){
                    if(next[1][now] != NULL) res += cnt[next[1][now]] ;
                    if(next[0][now] == NULL) return res ;
                    else now = next[0][now] ;
                }
            }
            return res + cnt[now] ;
        }

    }
}





