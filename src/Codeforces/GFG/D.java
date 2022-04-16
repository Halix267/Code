package Codeforces.GFG;
import java.util.*;

class Pair
{
    int a , t;
    public Pair(int a , int t)
    {
        this.a = a;
        this.t = t;
    }
}

public class D {
    static boolean check(double x , Pair ar[] , int k)
    {
        double mn = 0 , mx = 0;
        double temp = x;
        for(int i = 0 ; i < ar.length ; i++)
        {
            double now = Math.max(0,temp-ar[i].a);
            mn += (temp-now)*(double)ar[i].t;
            temp = now;
        }

        if(temp > 0)
            return false;


        temp = x;
        for(int i = ar.length-1 ; i >= 0 ; i--)
        {
            double now = Math.max(0,temp-ar[i].a);
            mx += (temp-now)*(double)ar[i].t;
            temp = now;
        }

        if(x*(double)k >= mn && x*(double)k <= mx)
            return true;

        return false;

    }

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            assert n>=1 && n<=200000;
            int k = sc.nextInt();
            assert k>=1 && n<=1e6;

            Pair a[] = new Pair[n];

            for(int i = 0 ; i < n ; i++)
            {
                a[i] = new Pair(sc.nextInt(),0);
            }

            for(int i = 0;  i < n ; i++)
            {
                a[i].t = sc.nextInt();
            }
            assert a.length==n;
            for(int i=0;i<n;i++){
                assert a[i].a>=1 && a[i].a<=1e6;
                assert a[i].t>=1 && a[i].t<=1e6;

            }
            String s = sc.next();

            Arrays.sort(a , (x,y)->{
                return x.t-y.t;
            });
            double l = 0 , r = 10000000000000.0D;
            for(int i = 1 ; i <= 100 ; i++)
            {
                double mid = (l+r)/(2.0);
                if(check(mid,a,k))
                    l = mid;

                else
                    r = mid;
            }
            System.out.println(r);
            System.out.println("~");
        }

    }
}

