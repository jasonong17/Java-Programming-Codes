class PascalCaseFormatter extends BaseFormatter{
  
  String string;
  String formatted = "";
  
  public PascalCaseFormatter(String string){
    this.string = string;
  }
  
  @Override
  public TextFormatter clone(String s){
    return new PascalCaseFormatter(s);
  }
  
  @Override
  public String format(){
     String[] word = string.split(" ");
     for(int i = 0; i < word.length; i++){
       word[i] = word[i].substring(0,1).toUpperCase() + word[i].substring(1, word[i].length()).toLowerCase();
       formatted += word[i];
     }
     return formatted;
  }
}