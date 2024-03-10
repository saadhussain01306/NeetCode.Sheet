import java.math.BigInteger;

class Solution {
    public int getSum(int a, int b) {
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigB = BigInteger.valueOf(b);

        // Perform addition using BigInteger
        BigInteger result = bigA.add(bigB);

        return result.intValue();
    }
}

----------------------------------------------------------------------------------------------------------------


class Solution {
    public int getSum(int a, int b) {
      int c; 
      while(b !=0 ) {
        c = (a&b);
        a = a ^ b;
        b = (c)<<1;
      }
      return a;
        
    }
}
