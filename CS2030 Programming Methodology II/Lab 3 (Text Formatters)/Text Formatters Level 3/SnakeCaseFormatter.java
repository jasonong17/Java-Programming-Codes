class SnakeCaseFormatter extends BaseFormatter{
  
  String string;
  
  public SnakeCaseFormatter(String string){
    this.string = string;
  }
  
  @Override
  public TextFormatter clone(String s){
    return new SnakeCaseFormatter(s);
  }
  
  @Override
  public String format(){
     String formatted = "";
     String[] word = string.split(" ");
     for(int i = 0; i < word.length-1; i++){
       formatted += word[i].toLowerCase() + "_";
     }
     formatted += word[word.length-1].toLowerCase();
     return formatted;
  }
}