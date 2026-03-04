import java.util.Arrays;

public class Driver{
  public static void main(String[] args){
    List test = new List();
    test.insert(1, 0);
    test.insert(1000, 19);
    test.print();
    System.out.println(test.bestPos(500));
  }
}
