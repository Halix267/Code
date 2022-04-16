package Codeforces.GFG;

import java.util.*;


public class Da {
    public static Node root;
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        assert t>=1 && t<=1000;
        while(t-->0){
            int n = sc.nextInt();
            assert n>=1 && n<=1e5;

            int k = sc.nextInt();
            assert k>=1 && k<=1e9;
            Trie tn = new Trie();
            root = tn.root;
            for(int i=0;i<n;i++) tn.insert(sc.next());
            String s = sc.next();

            boolean[] winner = DFS(tn,tn.root);
            if( !winner[0] || (k%2 == 0 && !winner[1])){
                System.out.println("Second");
                System.out.println("~");
            }
            else {
                System.out.println("First");
                System.out.println("~");
            }
        }




    }

    public static boolean[] DFS(Trie tn, Node cur){
        boolean[] winner = new boolean[2];
        boolean leaf = true;

        for(int i=0;i<26;i++){
            if(cur.children[i] != null){
                leaf = false;
                boolean[] win = DFS(tn,cur.children[i]);
                winner[0]|=!win[0];
                winner[1]|=!win[1];
            }
        }
        return (leaf) ? new boolean[]{false,true} : winner;
    }

}


class Node{
    Node[] children;

    public Node(){
        children = new Node[26];
    }
}

class Trie{
    Node root = new Node();

    public void insert(String s){
        Node cur =root;
        for(int i=0; i<s.length(); i++){
            if(cur.children[s.charAt(i) - 'a'] == null)
                cur.children[s.charAt(i) - 'a'] = new Node();
            cur = cur.children[s.charAt(i) - 'a'];
        }
    }
}