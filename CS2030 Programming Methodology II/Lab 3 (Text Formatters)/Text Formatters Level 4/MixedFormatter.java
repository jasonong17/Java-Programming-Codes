class MixedFormatter extends BaseFormatter{
  
  String string;
  
  public MixedFormatter(String string){
    this.string = string;
  }
  
  @Override
  public TextFormatter clone(String s){
    return new MixedFormatter(s);
  }
  
  @Override
  public String format(){
    String formatted = "";
    SnakeCaseFormatter sc = new SnakeCaseFormatter(string);
    KebabCaseFormatter kc = new KebabCaseFormatter(string);
    PascalCaseFormatter pc = new PascalCaseFormatter(string);
    
    String iLoveCs2030 = sc.format("I Love CS2030");
    int t = 0;
    char[] letters = iLoveCs2030.toCharArray();
    for(int i = 0; i < letters.length; i++){
      t += letters[i];
    }
    
    int r = string.charAt(0) % 3;
    
    if(r == 0){
      formatted += sc.format();
      int s = 0;
      char[] scLetters = formatted.toCharArray();
      for(int i = 0; i < scLetters.length; i++){
        s += scLetters[i];
      }
      if(s <= t){
        formatted = iLoveCs2030;
      }
    }
    else if(r == 1){
      formatted += kc.format();
      int s = 0;
      char[] kcLetters = formatted.toCharArray();
      for(int i = 0; i < kcLetters.length; i++){
        s += kcLetters[i];
      }
      if(s <= t){
        formatted = iLoveCs2030;
      }
    }
    else if(r == 2){
      formatted += pc.format();
      int s = 0;
      char[] pcLetters = formatted.toCharArray();
      for(int i = 0; i < pcLetters.length; i++){
        s += pcLetters[i];
      }
      if(s <= t){
        formatted = iLoveCs2030;
      }
    }
     return formatted;
  }
}