class CruiseCentre{
  
  Loader[] loaders = new Loader[60];
  int stop = 1;
  int j = 0;
  
  public CruiseCentre(){
  }
  
  public void assignCruises(Cruise[] cruises){
    if(cruises.length > 0){
      loaders[0] = new Loader();
    }
    
    for(int i = 0; i < cruises.length; i++){
      // checks if big cruise
      if(cruises[i].getCruiseCode().charAt(0) == 'B'){
        //change to big cruise
        cruises[i] = new BigCruise(cruises[i].getCruiseCode(), cruises[i].getInitialTime());
        // first loader
        for(j = 0; j < 60; j++){
          if(loaders[j].loadCruise(cruises[i])){
            if(loaders[j+1] == null){
                loaders[j+1] = new Loader();
                stop++;
            }
            // second loader
            for(int k = j; k < 60; k++){
              if(loaders[k].loadCruise(cruises[i])){
                break;
              }
              else if(loaders[k+1] == null){
                loaders[k+1] = new Loader();
                stop++;
              }
            }
            break;
          }
          else if(loaders[j+1] == null){
            loaders[j+1] = new Loader();
            stop++;
          }
        }
      }
      
      else{        
        for(j = 0; j < 60; j++){
          if(loaders[j].loadCruise(cruises[i])){
            break;
          }
          else if(loaders[j+1] == null){
            loaders[j+1] = new Loader();
            stop++;
          }
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