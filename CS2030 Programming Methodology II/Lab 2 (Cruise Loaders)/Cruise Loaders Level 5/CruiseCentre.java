class CruiseCentre{
  
  Loader[] loaders = new Loader[60];
  int stop = 1;
  int j = 0;
  int big = 0;
  int normal = 0;
  
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
        big++;
        cruises[i] = new BigCruise(cruises[i].getCruiseCode(), cruises[i].getInitialTime());
        for(j = 1; j <= 60; j++){
          //check if loader is multiple of 3(recycled loader)
          if(j % 3 == 0){
            if(loaders[j-1] == null){
              loaders[j-1] = new Loader();
              stop++;
            }
          }
          //first loader
          if(loaders[j-1].loadCruise(cruises[i], j)){
            if(loaders[j] == null){
              loaders[j] = new Loader();
              stop++;
            }
            // second loader
            for(int k = j+1; k <= 60; k++){
              //check if loader is multiple of 3(recycled loader)
              if(k % 3 == 0){
                if(loaders[k-1] == null){
                  loaders[k-1] = new Loader();
                  stop++;
                }
              }
              if(loaders[k-1].loadCruise(cruises[i], k)){
                break;
              }
              else if(loaders[k] == null){
                loaders[k] = new Loader();
                stop++;
              }
            }
            break;
          }
          else if(loaders[j] == null){
            //check if loader is multiple of 3(recycled loader)
            if(j+1 % 3 == 0){
              loaders[j-1] = new Loader();
            }
            else{
              loaders[j] = new Loader();
            }
            stop++;
          }
        }
      }
      //normal cruise
      else{        
        normal++;
        for(j = 1; j <= 60; j++){
          //check if loader is multiple of 3(recycled loader)
          if(j % 3 == 0){
            if(loaders[j-1] == null){
              loaders[j-1] = new Loader();
              stop++;
            }
          }
          if(loaders[j-1].loadCruise(cruises[i], j)){
            break;
          }
          else if(loaders[j] == null){
            if(j+1 % 3 == 0){
              loaders[j] = new Loader();
            }
            else{
              loaders[j] = new Loader();
            }
            stop++;
          }
        }
      }
    }
  }
  public int getLoader(){
    int loader = 0;
    for(int i = 1; i <= stop; i++){
      if(i % 3 != 0){
        loader++;
      }
    }
    return loader;
  }
  public int getRLoader(){
    int rloader = 0;
    for(int i = 1; i <= stop; i++){
      if(i % 3 == 0){
        rloader++;
      }
    }
    return rloader;
  }
  
  public String toString(Cruise[] cruises){
    String str = "";
    str += "+==================================+";
    str += "\n| Cruise Statistics                |";
    str += "\n+----------------------------------+";
    if(normal < 10){
      str += "\n| Number of normal cruises   =   " + normal + " |";
    }
    else{
      str += "\n| Number of normal cruises   =  " + normal + " |";
    }
    if(big < 10){
      str += "\n| Number of big cruises      =   " + big + " |";
    }
    else{
      str += "\n| Number of big cruises      =  " + big + " |";
    }
    str += "\n+==================================+";
    str += "\n| Equipment statistics             |";
    str += "\n+----------------------------------+";
    if(getLoader() < 10){
      str += "\n| Number of loaders          =   " + getLoader() + " |";
    }
    else{
      str += "\n| Number of loaders          =  " + getLoader() + " |";
    }
    if(getRLoader() < 10){
      str += "\n| Number of recycled loaders =   " + getRLoader() + " |";
    }
    else{
      str += "\n| Number of recycled loaders =  " + getRLoader() + " |";
    }
    str += "\n+==================================+";
    
    for(int i = 1; i <= stop; i++){
      if(i % 3 != 0){
        if(i < 10){
          str += "\n| Loader " + i + " serves:                 |" + loaders[i-1].toString(cruises);
          str += "\n+==================================+";
        }
        else{
          str += "\n| Loader " + i + " serves:                |" + loaders[i-1].toString(cruises);
          str += "\n+==================================+";
        }
      }
    }
    for(int i = 1; i <= stop; i++){
      if(i % 3 == 0){
        if(i < 10){
          str += "\n| Loader " + i + " (recycled) serves:      |" + loaders[i-1].toString(cruises);
          str += "\n+==================================+";
        }
        else{
          str += "\n| Loader " + i + " (recycled) serves:     |" + loaders[i-1].toString(cruises);
          str += "\n+==================================+";
        }
      }
    }
    
    return str;
  }
}
