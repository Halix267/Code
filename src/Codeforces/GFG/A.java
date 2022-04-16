package Codeforces.GFG;
import java.util.*;


public class A{

    static boolean check(int len,int n,int ex,int ey,int[] x,int[] y) {
        int sx=x[n],sy=y[n];
        for(int i=1;i+len-1<=n;i++) {
            int l=i,r=i+len-1;
            int mx=x[r]-x[l-1];
            int my=y[r]-y[l-1];
            int tx=sx-mx,ty=sy-my;
            int dis=Math.abs(tx-ex)+Math.abs(ty-ey);
            if(len>=dis&&(len%2==dis%2))	return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            int n=sc.nextInt();
            String s=sc.next();
            int ex=sc.nextInt();
            int ey=sc.nextInt();
            String c = sc.next();
            int[] x= new int[n+1];
            int[] y = new int[n+1];

            s=" "+s;
            for(int i=1;i<=n;i++) {
                char ch=s.charAt(i);
                if(ch=='L')
                    x[i]=-1;
                if(ch=='R')
                    x[i]=1;
                if(ch=='U')
                    y[i]=1;
                if(ch=='D')
                    y[i]=-1;
            }


            x[0]=0;	y[0]=0;
            for(int i=1;i<=n;i++) {
                x[i]=x[i]+x[i-1];
                y[i]=y[i]+y[i-1];
            }

            int left=0,right=n+1,ans=-1;
            while(left<=right) {
                int mid=(left+right)/2;
                if(check(mid,n,ex,ey,x,y)) {
                    ans=mid;
                    right=mid-1;
                }
                else left=mid+1;
            }
            System.out.println(ans);
            System.out.println("~");
            t--;
        }
        sc.close();
    }
}