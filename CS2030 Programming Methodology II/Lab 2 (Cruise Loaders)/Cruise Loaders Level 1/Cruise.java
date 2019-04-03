class Cruise{

    private String cruiseCode;
    private String time;

    public Cruise(String cruiseCode, String time){
        this.cruiseCode = cruiseCode;
        this.time = time;
    }

    public String toString(){
        if(time.length() < 2){
            return cruiseCode + "@000" + time;
        }
        else if(time.length() < 3){
            return cruiseCode + "@00" + time;
        }
        else if(time.length() < 4){
            return cruiseCode + "@0" + time;
        }
        else{
            return cruiseCode + "@" + time;
        }
    }
}