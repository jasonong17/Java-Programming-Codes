class Loader{
  
  private Cruise[] assignedCruises = new Cruise[60];
  
  int time = 0;
  int counter = 0;
  
  public Loader(){
  }
  
  public boolean loadCruise(Cruise cruise, int i){
    if(i % 3 == 0){
      if(time <= cruise.getTime()){
        time = cruise.getTime() + cruise.getLoadTime() + 90;
        assignedCruises[counter] = cruise;
        counter++;
        
        return true;
      }
      else{
        return false;
      }
    }
    else{
      
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
  }
  
  public String toString(Cruise[] cruises){
    String str = "";
    for(int i = 0; i < counter; i++){
         str +=   "\n    " + assignedCruises[i];
    }
    return str;
  }
}