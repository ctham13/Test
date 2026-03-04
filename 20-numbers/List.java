import java.util.*;
import java.math.*;

public class List{
  private int[] list;
  private int nums;
  private double[] probList;
  public List(){
    list = new int[20];
    probList = new double[20];
    nums = 0;
  }
  public int bestPos(int n){
    for(int x = 0; x < list.length; x++){
      if(list[x] == 0){
        insert(n, x);
        if(inOrder()){
          //calc probablity, insert into probList
        }
        list[x] = 0;
      }
    }
    double bestProb = 0.0;
    int bestProbIndex = 0;
    for(int x = 0; x < probList.length; x++){
      if(probList[x] > bestProb){
        bestProbIndex = x;
        bestProb = probList[x];
      }
    }
    if(bestProb == 0.0){

    }
    return bestProbIndex;
  }
  public void insert(int value, int pos){
    list[pos] = value;
  }
  public double probability(int prob, int spots){
    return nCr(prob, spots).divide(nCr(20 - nums, 1000)).doubleValue();
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
