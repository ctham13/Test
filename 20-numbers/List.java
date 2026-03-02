import java.util.*;
import java.math.*;

public class List{
  private int[] list;
  private int nums;
  public List(){
    list = new int[20];
    nums = 0;
  }
  public double probability(int prob, int spots){
    return nCr(prob, spots).divide(nCr(20 - nums, 1000));
  }
  public boolean inOrder(){
      int prev = Integer.MIN_VALUE;
      for (int n : list){
          if (n != 0){
              if (n < prev){
                return false;
              }
              prev = n;
          }
      }
      return true;
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
}
