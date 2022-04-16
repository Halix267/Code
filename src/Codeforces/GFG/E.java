package Codeforces.GFG;

//Initial Template for Java

import java.util.*;

public class E{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {

            String s = sc.nextLine().trim();

            System.out.println(maximum_frequency_char(s));

        }
    }

    static char maximum_frequency_char(String s) {

        Map<Character, Integer> freq = new HashMap<>();

        int mx = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            freq.put(ch,freq.getOrDefault(ch,0)+1);
            mx = Math.max(mx, freq.get(ch));
        }
        for (char i:freq.keySet()) {
            if (freq.get(i) == mx) {
                return i;
            }
        }
        return '#';
    }
}

