package Codeforces.GFG;
import java.util.Scanner;


public class B {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            long k=sc.nextLong();
            String s = sc.next();
            long l=1,mid;
            long r = (long)n*(long)m;
            long ans=-1;
            while(l<=r)
            {
                mid=(l+r)/2;
                long c=0;
                for(long i=1;i<=n;i++)
                    c+=Math.min(m,(mid-1)/i);

                if(c>=k)
                    r=mid-1;
                else{
                    ans=mid;
                    l=mid+1;
                }
            }
            System.out.println(ans);
            System.out.println("~");
        }

    }

}