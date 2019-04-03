import java.util.stream.IntStream;
import java.util.Scanner;

class Main{
  public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     System.out.print(isSquare(sc.nextInt()));
     sc.close();
  }

  static boolean isPerfect(int num){
      int stream = IntStream
          .range(1, num)
          .filter(x -> num % x == 0)
          .sum();
      return(stream == num);
  }

  static boolean isSquare(int num){
      int stream = IntStream
           .rangeClosed(1, num)
           .filter(x -> x*x == num)
           .map(x -> x*x)
           .sum();
      return(stream == num);
  }
}