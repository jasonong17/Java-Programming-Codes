abstract class BaseFormatter implements TextFormatter, Comparable<TextFormatter>{
  
  protected int sumASCII(String s){
    int sum = 0;
    char[] letters = s.toCharArray();
    for(int i = 0; i < letters.length; i++){
      sum += letters[i];
    }
    return sum;
  }
  
  @Override
  public int compareTo(TextFormatter t){
    return sumASCII(this.format()) - sumASCII(t.format());
  }

}