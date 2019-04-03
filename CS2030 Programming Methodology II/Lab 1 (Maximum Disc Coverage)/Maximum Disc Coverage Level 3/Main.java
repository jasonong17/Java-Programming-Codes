import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int pair = sc.nextInt();
        Point[] arr = new Point[pair];
        for(int i = 0; i < pair; i++){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            arr[i] = new Point(x,y);
        }
        
        for(int i = 0; i < pair-1; i++){ 
            if(arr[i].getDistance(arr[i+1]) <= 2){
                System.out.println(arr[i].toString() + " and " + arr[i+1].toString() + " coincides with circle of centre " + Circle.circleCentre(arr[i], arr[i+1]).toString());
            }
        }
        sc.close();
    }
}