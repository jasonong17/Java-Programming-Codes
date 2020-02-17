import java.util.Scanner;

class Main{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int restoNum = sc.nextInt();
        
        for(int i = 0; i < restoNum; i++){
            
            int menuNum = sc.nextInt();
            sc.nextLine();
            String restoName = sc.nextLine();
            boolean hasPancakes = false;
            boolean hasPeasoup = false;
            
            for(int j = 0; j < menuNum; j++){
                String menuName = sc.nextLine();
                if(menuName.equals("pancakes")){
                    hasPancakes = true;
                }
                if(menuName.equals("pea soup")){
                    hasPeasoup = true;
                }
            }
            
            if(hasPancakes && hasPeasoup){
                System.out.println(restoName);
                break;
            }
            else if((!hasPancakes || !hasPeasoup) && i == restoNum-1){
                System.out.println("Anywhere is fine I guess");
            }
            else{
            }
        }
        sc.close();
    }
}
                   
                