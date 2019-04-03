class KebabCaseFormatter extends BaseFormatter{
  
  String string;
  String formatted = "";
  
  public KebabCaseFormatter(String string){
    this.string = string;
  }
  
  @Override
  public TextFormatter clone(String s){
    return new KebabCaseFormatter(s);
  }
  
  @Override
  public String format(){
     String[] word = string.split(" ");
     for(int i = 0; i < word.length-1; i++){
       formatted += word[i].toLowerCase() + "-";
     }
     formatted += word[word.length-1].toLowerCase();
     return formatted;
  }
}