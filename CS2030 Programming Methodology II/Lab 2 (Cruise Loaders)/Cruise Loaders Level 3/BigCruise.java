public class BigCruise extends Cruise{
  
  public BigCruise(String cruiseCode, int time){
    super(cruiseCode, time);
  }
  
  @Override
  public int getLoadTime(){
    return 60;
  }
}