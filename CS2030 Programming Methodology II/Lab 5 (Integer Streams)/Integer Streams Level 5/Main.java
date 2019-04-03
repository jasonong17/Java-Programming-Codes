import java.util.stream.IntStream;
import java.util.OptionalDouble;
import java.util.Scanner;

class Main{
  public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     System.out.println(primeFactors(sc.nextInt()));
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

  static long countRepeats(int[] array){
      long stream = IntStream
          .range(1, array.length)
          .filter(x -> x-2 < 0 || array[x-2] != array[x])
          .filter(x -> array[x] == array[x-1])
          .count();
      return stream;
  }

  static String variance(int[] array){
      if(array.length < 2 || array == null){
          return "OptionalDouble.empty";
      }
      else{
      double elements = IntStream
          .of(array)
          .count();
      double avg = IntStream
          .of(array)
          .average()
          .getAsDouble();
      double sigmaSquared = IntStream
          .of(array)
          .mapToDouble(x -> x-avg)
          .map(x -> x*x)
          .sum();
      double var = sigmaSquared/(elements-1);
          return "OptionalDouble[" + var + "]";
      }
  }

  static IntStream factors(int x){
      IntStream stream = IntStream
          .range(1, x)
          .filter(y -> x%y == 0);
      return stream;
  }

  static boolean isPrime(int x){
      boolean prime = IntStream
          .range(2, x)
          .noneMatch(y -> x%y == 0);
      return prime;
  }

  static IntStream primeFactors(int x){
     IntStream stream = IntStream
         .rangeClosed(2, x)
         .filter(y -> x%y == 0)
         .filter(y -> isPrime(y));
     return stream;
  }
}