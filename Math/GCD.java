public class GCD {
    public static void main(String args[]){
        System.out.println(gcd(12,24));
    }
    public static int gcd(int m,int n){
        int t;
        if(m<n)
            t=m;
        else
            t=n;

        while(true){ //1
            if(m%t==0 && n%t==0)
                return t;
            else
                t--;
        }  
    }
}
