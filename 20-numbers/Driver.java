import java.util.Arrays;
import java.math.*;

public class Driver{
  public static void main(String[] args){
    
    List test = new List();
    test.insert(1, 0);
    test.insert(1000, 19);
    test.print();
    System.out.println(test.bestPos(100));

    //System.out.println(probability(100, 1, 1));
  }
  public static BigInteger nCr(int n, int r) {
      if (r > n){
        return BigInteger.ZERO;
      }
      BigInteger ans = BigInteger.ONE;
      for (int x = 0; x < r; x++) {
          ans = ans.multiply(BigInteger.valueOf(n - x)).divide(BigInteger.valueOf(x + 1));
      }
      return ans;
  }
  public static double probability(int prob, int spots, int rem){
    /*
    System.out.println(nCr(prob, spots));
    System.out.println(nCr(1000, rem));
    System.out.println(nCr(prob, spots).divide(nCr(1000, rem)));
    */
    return (nCr(prob, spots).doubleValue() / (nCr(1000, rem)).doubleValue());
  }
}
