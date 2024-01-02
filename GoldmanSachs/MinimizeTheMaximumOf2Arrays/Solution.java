package GoldmanSachs.MinimizeTheMaximumOf2Arrays;


// leetcode problem: https://leetcode.com/problems/minimize-the-maximum-of-two-arrays/submissions/

class Solution {
    long gcd(long a, long b)
    {
        if((a%b)==0){
            return b;
        }else{
            return gcd(b, a%b);
        }
    }
    
    public void bs(long l, long h, int divisor1, int divisor2, long lcm, long ans, int c1, int c2) {
        if(l<=h){
            long m=(l+h)/2;
            
            long a, b, c;
            
            a=m-(m/divisor1);
            b=m-(m/divisor2);
            c=m-(m/divisor1)-(m/divisor2)+(m/lcm);
            
            //cout<<m<<" "<<a<<" "<<b<<" "<<c<<"\n";
            
            if(a>=c1 && b>=c2 && a+b-c>=c1+c2){
                ans=m;
                bs(l, m-1, divisor1, divisor2, lcm, ans, c1, c2);
            }else{
                bs(m+1, h, divisor1, divisor2, lcm, ans, c1, c2);
            }
        }
    }

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
       long l = 1;
       long r = (int) (2 * 1e9);
       long ans = r;
       long lcm = (1L * divisor1 * divisor2) / gcd(divisor1, divisor2);

       for(; l<=r;) {
           long mid = (l+r)/2;
           long x = mid - mid / divisor1; 
           long y = mid - mid/ divisor2;
           long z = mid - mid/lcm;
           if(x < 1L * uniqueCnt1 || y < 1L * uniqueCnt2 || z < 1L * (uniqueCnt1 + uniqueCnt2)) {
               l = mid+1;
           }else {
               ans = Math.min(ans, mid);
               r = mid -1;
           }
       }

       return (int) ans;
    }
}