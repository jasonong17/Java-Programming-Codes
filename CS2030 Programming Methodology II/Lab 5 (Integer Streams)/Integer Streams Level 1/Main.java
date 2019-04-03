import java.util.stream.IntStream;
import java.util.Scanner;

class Main{
  public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     System.out.print(isPerfect(sc.nextInt()));
     sc.close();
  }

  static boolean isPerfect(int num){
      int stream = IntStream
          .range(1, num)
          .filter(x -> num % x == 0)
          .sum();
      return(stream == num);
  }
}