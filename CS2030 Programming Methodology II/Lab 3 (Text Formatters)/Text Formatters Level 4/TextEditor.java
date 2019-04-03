import java.util.*;
class TextEditor{
  
  List<TextFormatter> formatter;
  ArrayList<String> words = new ArrayList<String>();
  PriorityQueue<TextFormatter> output = new PriorityQueue<TextFormatter>();
  int size;
  
  public TextEditor(List<TextFormatter> formatter){
    this.formatter = formatter;
  }
  
  public void addString(String s){
    words.add(s);
  }
  
  public void printAll(){
    for(String s : words){
      for(TextFormatter f : formatter){
        output.add(f.clone(s));
      }
    }
    size = output.size();
    for(int i = 0; i < size; i++){
      System.out.println(output.poll().format());
    }
  }
}