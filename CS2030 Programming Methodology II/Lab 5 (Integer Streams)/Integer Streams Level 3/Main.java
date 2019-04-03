import java.util.stream.IntStream;

class Main{
  public static void main(String[] args){
     List list = new List();
     list.input();
     int[] arr = list.toArr();
     System.out.println("Number of occurrences: " + countRepeats(arr));
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
}