class CruiseCentre{
  
  Loader[] loaders = new Loader[30];
  int stop = 1;
  int j = 0;
  
  public CruiseCentre(){
  }
  
  public void assignCruises(Cruise[] cruises){
    if(cruises.length > 0){
      loaders[0] = new Loader();
    }
    for(int i = 0; i < cruises.length; i++){
      for(j = 0; j < 30; j++){
        if(loaders[j].loadCruise(cruises[i])){
          break;
        }
        else if(!loaders[j].loadCruise(cruises[i]) && loaders[j+1] == null){
          loaders[j+1] = new Loader();
          stop++;
        }
      }
    }
  }
  
  public String toString(Cruise[] cruises){
    String str = "";
    for(int i = 1; i <= stop; i++){
      if (i == 1){
        str += "Loader " + i + " serves:" + loaders[i-1].toString(cruises);
      }
      else{
        str += "\nLoader " + i + " serves:" + loaders[i-1].toString(cruises);
      }
    }
    return str;
  }
}