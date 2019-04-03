class Cruise{

    private String cruiseCode;
    private int time;

    public Cruise(String cruiseCode, int time){
        this.cruiseCode = cruiseCode;
        this.time = time;
    }
    public String getCruiseCode(){
      return cruiseCode;
    }
    public int getTime(){
      int totalTime = (time/100)*60 + time%100;
      return totalTime;
    }
    public int getLoadTime(){
      return 30;
    }

    public String toString(){
        return cruiseCode + "@" + String.format("%04d", time);
    }
}