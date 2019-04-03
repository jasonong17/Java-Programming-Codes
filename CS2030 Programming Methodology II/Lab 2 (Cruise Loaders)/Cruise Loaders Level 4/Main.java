import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Cruise[] cruises = new Cruise[num];
        for(int i = 0; i < num; i++){
            String cruiseCode = sc.next();
            int time = sc.nextInt();
            cruises[i] = new Cruise(cruiseCode, time);
        }
        CruiseCentre cruiseCentre = new CruiseCentre();
        cruiseCentre.assignCruises(cruises);
        System.out.println(cruiseCentre.toString(cruises));
        sc.close();
    }
}