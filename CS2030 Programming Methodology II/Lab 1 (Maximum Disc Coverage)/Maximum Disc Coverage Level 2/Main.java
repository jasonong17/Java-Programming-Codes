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
        
        for(int i = 0; i < pair; i++){ 
            if(i > 0){
                System.out.println(arr[i-1] + " and " + arr[i] + " has mid-point " + arr[i-1].getMidpoint(arr[i]) + " and angle " + String.format("%.3f", arr[i].getAngle(arr[i-1])));
            }
        }
        sc.close();
    }
}