import java.util.Scanner;
class Main{
  
  public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);
    
    int[][][]grid = new int[6][3][3];
    
    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 3; j++){
        for(int k = 0; k < 3; k++){
          grid[i][j][k] = sc.nextInt();
        }
      }
    }
    
    Rubik rubik = new Rubik(grid);
    while(sc.hasNext()){
      String input = sc.next();
      if(input.equals("F")){
        rubik = rubik.frontfaceRight();
      }
      else if(input.equals("R")){
        rubik = rubik.rightfaceRight();
      }
      else if(input.equals("U")){
        rubik = rubik.upfaceRight();
      }
      else if(input.equals("L")){
        rubik = rubik.leftfaceRight();
      }
      else if(input.equals("B")){
        rubik = rubik.backfaceRight();
      }
      else if(input.equals("D")){
        rubik = rubik.downfaceRight();
      }
      else if(input.equals("F'")){
        rubik = rubik.frontfaceLeft();
      }
      else if(input.equals("R'")){
        rubik = rubik.rightfaceLeft();
      }
      else if(input.equals("U'")){
        rubik = rubik.upfaceLeft();
      }
      else if(input.equals("L'")){
        rubik = rubik.leftfaceLeft();
      }
      else if(input.equals("B'")){
        rubik = rubik.backfaceLeft();
      }
      else if(input.equals("D'")){
        rubik = rubik.downfaceLeft();
      }
      else if(input.equals("F2")){
        rubik = rubik.frontfaceHalf();
      }
      else if(input.equals("R2")){
        rubik = rubik.rightfaceHalf();
      }
      else if(input.equals("U2")){
        rubik = rubik.upfaceHalf();
      }
      else if(input.equals("L2")){
        rubik = rubik.leftfaceHalf();
      }
      else if(input.equals("B2")){
        rubik = rubik.backfaceHalf();
      }
      else if(input.equals("D2")){
        rubik = rubik.downfaceHalf();
      }
    }
    
    System.out.println(rubik);
    sc.close();
  }
}