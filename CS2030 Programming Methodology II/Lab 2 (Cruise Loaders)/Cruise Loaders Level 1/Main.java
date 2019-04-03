import java.util.Scanner;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Cruise[] schedule = new Cruise[num];
        for(int i = 0; i < num; i++){
            String cruiseCode = sc.next();
            String time = sc.next();
            schedule[i] = new Cruise(cruiseCode, time);
            System.out.println(schedule[i]);
        }
        sc.close();
    }
}