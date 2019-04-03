import java.util.*;
class TextEditor{
  
  List<TextFormatter> formatter;
  ArrayList<String> words = new ArrayList<String>();
  ArrayList<TextFormatter> output = new ArrayList<TextFormatter>();
  
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
    for(TextFormatter out : output){
      System.out.println(out.format());
    }
  }
}