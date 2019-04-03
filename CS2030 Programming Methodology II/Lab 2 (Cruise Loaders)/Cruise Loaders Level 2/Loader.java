class Loader{

    private Cruise[] assignedCruises = new Cruise[30];

    int time = 0;
    int counter = 0;
    int stop = 0;

    public Loader(){
    }

    public boolean loadCruise(Cruise cruise){
      if(time <= cruise.getTime()){
        time = cruise.getTime() + cruise.getLoadTime();
        assignedCruises[counter] = cruise;
        counter++;
        return true;
      }
      else{
        return false;
      }
    }
    
    public String toString(Cruise[] cruises){
      String str = "";
      for(int i = 0; i < counter; i++){
        str += "\n    " + assignedCruises[i];
      }
      return str;
    }
}