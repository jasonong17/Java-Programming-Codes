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
        
        int maxCoverage = 0;
        for(int i = 0; i < pair; i++){
            for(int j = 0; j < pair; j++){
                if(arr[i].getDistance(arr[j]) <= 2){
                    int coverage = 0;
                    Circle circle = new Circle(Circle.circleCentre(arr[i], arr[j]));

                    for(int k = 0; k < pair; k++){
                        if(circle.hasPoint(arr[k])){
                            coverage++;
                        }
                    }

                    if(coverage > maxCoverage){
                        maxCoverage = coverage;
                    }

                }
            }
        }
        System.out.println("Maximum Disc Coverage: " + maxCoverage);
        sc.close();
    }
}
