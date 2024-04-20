class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        while(low < high) {
            int mid = low + (high-low)/2;
            if(isPossible(mid,divisor1,divisor2,uniqueCnt1,uniqueCnt2))high=mid;
            else low = mid+1;
        }
        return low;
    }

    private boolean isPossible(long num,long d1,long d2, long cnt1,long cnt2) {
        long divisibleByBothD1AndD2 = num/lcm(d1,d2);
        long canBeStoredInArr2 = (num/d1) - divisibleByBothD1AndD2;
        long canBeStoredInArr1 = (num/d2) - divisibleByBothD1AndD2;
        long rest = num - (divisibleByBothD1AndD2 + canBeStoredInArr1 + canBeStoredInArr2);
        if(cnt1 >= canBeStoredInArr1) {
            rest -=(cnt1 - canBeStoredInArr1);
        }
        if(cnt2 >= canBeStoredInArr2) {
            rest -= cnt2 - canBeStoredInArr2;
        }
        return rest>=0;
    }

    public long lcm(long d1,long d2){
        return (d1*d2)/gcd(d1,d2);
    }
    public long gcd(long a,long b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}