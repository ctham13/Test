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
          double prob = 1.0;
          int spots = 0;
          for(int i = 0; i < list.length; i++){
            if(list[i] == 0){
              spots++;
            }
            if(list[i] != 0 && spots != 0){
              prob *= probability(list[i]- list[i - spots], spots);
              spots = 0;
            }
          }
          probList[x] = prob;
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
      System.out.println("cannot be placed");
    }
    System.out.println(Arrays.toString(probList));
    probList = new double[20];
    return bestProbIndex;
  }
  public void insert(int value, int pos){
    list[pos] = value;
    nums++;
  }
  public void print(){
    System.out.println(Arrays.toString(list));
  }
  public double probability(int prob, int spots){
    return (nCr(prob, spots).doubleValue() / (nCr(1000, 20 - nums)).doubleValue());
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
