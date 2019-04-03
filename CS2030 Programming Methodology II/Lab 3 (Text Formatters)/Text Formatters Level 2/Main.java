import java.util.*;
class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    ArrayList<TextFormatter> a = new ArrayList<TextFormatter>();
    a.add(new SnakeCaseFormatter(""));
    a.add(new KebabCaseFormatter(""));
    a.add(new PascalCaseFormatter(""));
    TextEditor textEditor = new TextEditor(a);
    
    boolean hasNext = sc.hasNext();
    while(hasNext){
      String string = sc.nextLine();
      textEditor.addString(string);
      hasNext = sc.hasNext();
    }
    textEditor.printAll();
    sc.close();
  }
}