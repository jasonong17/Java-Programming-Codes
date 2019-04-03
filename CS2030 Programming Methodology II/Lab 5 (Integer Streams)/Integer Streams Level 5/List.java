import java.util.Scanner;
import java.util.ArrayList;

class List{

    ArrayList<Integer> list = new ArrayList<Integer>();

    public List(){
    }

    public void input(){
      Scanner sc = new Scanner(System.in);
      while(sc.hasNextInt()){
          list.add(sc.nextInt());
      }
      sc.close();
    }

    public int[] toArr(){
        int[] arr = new int[list.size()];
        int i = 0;
        for(int num: list){
           arr[i] = num;
           i++;
        }
        return arr;
    }
}