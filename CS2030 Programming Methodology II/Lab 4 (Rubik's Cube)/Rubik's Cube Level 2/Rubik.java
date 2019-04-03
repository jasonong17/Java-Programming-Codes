class Rubik{
  
  int[][][] grid = new int[6][3][3];
  
  public Rubik(int[][][] grid){
    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 3; j++){
        for(int k = 0; k < 3; k++){
          this.grid[i][j][k] = grid[i][j][k];
        }
      }
    }
  }
  
  public Rubik viewRight(){
    int[][][] new3dGrid = new int[6][3][3];
    
    //first face (top view)
    int[][] newTopGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newTopGrid[i][j] = grid[0][i][j];
      }
    }
    Face newTopFace = new Face(newTopGrid).rotateRight();
    int[][] finalTopGrid = newTopFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j< 3; j++){
        new3dGrid[0][i][j] = finalTopGrid[i][j];
      }
    }
    
    //second face (left view)
    int[][] newLeftGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newLeftGrid[i][j] = grid[2][i][j];
      }
    }
    Face newLeftFace = new Face(newLeftGrid);
    int[][] finalLeftGrid = newLeftFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[1][i][j] = finalLeftGrid[i][j];
      }
    }
    
    //third face (front view)
    int[][] newFrontGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newFrontGrid[i][j] = grid[3][i][j];
      }
    }
    Face newFrontFace = new Face(newFrontGrid);
    int[][] finalFrontGrid = newFrontFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[2][i][j] = finalFrontGrid[i][j];
      }
    }
    
    //fourth face (right view)
    int[][] newRightGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newRightGrid[i][j] = grid[5][i][j];
      }
    }
    Face newRightFace = new Face(newRightGrid).rotateHalf();
    int[][] finalRightGrid = newRightFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[3][i][j] = finalRightGrid[i][j];
      }
    }
    
    //fifth face (bottom view)
    int[][] newBottomGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newBottomGrid[i][j] = grid[4][i][j];
      }
    }
    Face newBottomFace = new Face(newBottomGrid).rotateLeft();
    int[][] finalBottomGrid = newBottomFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[4][i][j] = finalBottomGrid[i][j];
      }
    }
    
    //sixth face (back view)
    int[][] newBackGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newBackGrid[i][j] = grid[1][i][j];
      }
    }
    Face newBackFace = new Face(newBackGrid).rotateHalf();
    int[][] finalBackGrid = newBackFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[5][i][j] = finalBackGrid[i][j];
      }
    }
    
    Rubik newRubik = new Rubik(new3dGrid);
    return newRubik;
  }
  
  public Rubik viewLeft(){
    int[][][] new3dGrid = new int[6][3][3];
    
    //first face (top view)
    int[][] newTopGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newTopGrid[i][j] = grid[0][i][j];
      }
    }
    Face newTopFace = new Face(newTopGrid).rotateLeft();
    int[][] finalTopGrid = newTopFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j< 3; j++){
        new3dGrid[0][i][j] = finalTopGrid[i][j];
      }
    }
    
    //second face (left view)
    int[][] newLeftGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newLeftGrid[i][j] = grid[5][i][j];
      }
    }
    Face newLeftFace = new Face(newLeftGrid).rotateHalf();
    int[][] finalLeftGrid = newLeftFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[1][i][j] = finalLeftGrid[i][j];
      }
    }
    
    //third face (front view)
    int[][] newFrontGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newFrontGrid[i][j] = grid[1][i][j];
      }
    }
    Face newFrontFace = new Face(newFrontGrid);
    int[][] finalFrontGrid = newFrontFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[2][i][j] = finalFrontGrid[i][j];
      }
    }
    
    //fourth face (right view)
    int[][] newRightGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newRightGrid[i][j] = grid[2][i][j];
      }
    }
    Face newRightFace = new Face(newRightGrid);
    int[][] finalRightGrid = newRightFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[3][i][j] = finalRightGrid[i][j];
      }
    }
    
    //fifth face (bottom view)
    int[][] newBottomGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newBottomGrid[i][j] = grid[4][i][j];
      }
    }
    Face newBottomFace = new Face(newBottomGrid).rotateRight();
    int[][] finalBottomGrid = newBottomFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[4][i][j] = finalBottomGrid[i][j];
      }
    }
    
    //sixth face (back view)
    int[][] newBackGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newBackGrid[i][j] = grid[3][i][j];
      }
    }
    Face newBackFace = new Face(newBackGrid).rotateHalf();
    int[][] finalBackGrid = newBackFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[5][i][j] = finalBackGrid[i][j];
      }
    }
    
    Rubik newRubik = new Rubik(new3dGrid);
    return newRubik;
  }
  
  public Rubik viewUp(){
    int[][][] new3dGrid = new int[6][3][3];
    
    //first face (top view)
    int[][] newTopGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newTopGrid[i][j] = grid[5][i][j];
      }
    }
    Face newTopFace = new Face(newTopGrid);
    int[][] finalTopGrid = newTopFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j< 3; j++){
        new3dGrid[0][i][j] = finalTopGrid[i][j];
      }
    }
    
    //second face (left view)
    int[][] newLeftGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newLeftGrid[i][j] = grid[1][i][j];
      }
    }
    Face newLeftFace = new Face(newLeftGrid).rotateRight();
    int[][] finalLeftGrid = newLeftFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[1][i][j] = finalLeftGrid[i][j];
      }
    }
    
    //third face (front view)
    int[][] newFrontGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newFrontGrid[i][j] = grid[0][i][j];
      }
    }
    Face newFrontFace = new Face(newFrontGrid);
    int[][] finalFrontGrid = newFrontFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[2][i][j] = finalFrontGrid[i][j];
      }
    }
    
    //fourth face (right view)
    int[][] newRightGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newRightGrid[i][j] = grid[3][i][j];
      }
    }
    Face newRightFace = new Face(newRightGrid).rotateLeft();
    int[][] finalRightGrid = newRightFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[3][i][j] = finalRightGrid[i][j];
      }
    }
    
    //fifth face (bottom view)
    int[][] newBottomGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newBottomGrid[i][j] = grid[2][i][j];
      }
    }
    Face newBottomFace = new Face(newBottomGrid);
    int[][] finalBottomGrid = newBottomFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[4][i][j] = finalBottomGrid[i][j];
      }
    }
    
    //sixth face (back view)
    int[][] newBackGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newBackGrid[i][j] = grid[4][i][j];
      }
    }
    Face newBackFace = new Face(newBackGrid);
    int[][] finalBackGrid = newBackFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[5][i][j] = finalBackGrid[i][j];
      }
    }
    
    Rubik newRubik = new Rubik(new3dGrid);
    return newRubik;
  }
  
  public Rubik viewDown(){
    int[][][] new3dGrid = new int[6][3][3];
    
    //first face (top view)
    int[][] newTopGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newTopGrid[i][j] = grid[2][i][j];
      }
    }
    Face newTopFace = new Face(newTopGrid);
    int[][] finalTopGrid = newTopFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j< 3; j++){
        new3dGrid[0][i][j] = finalTopGrid[i][j];
      }
    }
    
    //second face (left view)
    int[][] newLeftGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newLeftGrid[i][j] = grid[1][i][j];
      }
    }
    Face newLeftFace = new Face(newLeftGrid).rotateLeft();
    int[][] finalLeftGrid = newLeftFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[1][i][j] = finalLeftGrid[i][j];
      }
    }
    
    //third face (front view)
    int[][] newFrontGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newFrontGrid[i][j] = grid[4][i][j];
      }
    }
    Face newFrontFace = new Face(newFrontGrid);
    int[][] finalFrontGrid = newFrontFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[2][i][j] = finalFrontGrid[i][j];
      }
    }
    
    //fourth face (right view)
    int[][] newRightGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newRightGrid[i][j] = grid[3][i][j];
      }
    }
    Face newRightFace = new Face(newRightGrid).rotateRight();
    int[][] finalRightGrid = newRightFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[3][i][j] = finalRightGrid[i][j];
      }
    }
    
    //fifth face (bottom view)
    int[][] newBottomGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newBottomGrid[i][j] = grid[5][i][j];
      }
    }
    Face newBottomFace = new Face(newBottomGrid);
    int[][] finalBottomGrid = newBottomFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[4][i][j] = finalBottomGrid[i][j];
      }
    }
    
    //sixth face (back view)
    int[][] newBackGrid = new int[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        newBackGrid[i][j] = grid[0][i][j];
      }
    }
    Face newBackFace = new Face(newBackGrid);
    int[][] finalBackGrid = newBackFace.getGrid();
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        new3dGrid[5][i][j] = finalBackGrid[i][j];
      }
    }
    
    Rubik newRubik = new Rubik(new3dGrid);
    return newRubik;
  }
  
  public String toString(){
    String rubikString = "";
    
    for(int i = 0; i < 3; i++){
      rubikString += "......";
      for(int j = 0; j < 3; j++){
        if(grid[0][i][j] < 10){
          rubikString += "0" + grid[0][i][j];
        }
        else{
          rubikString += grid[0][i][j];
        }
      }
      rubikString += "......" + "\n";
    }
    
    for(int j = 0; j < 3; j++){
      for(int i = 1; i < 4; i++){
        for(int k = 0; k < 3; k++){
          if(grid[i][j][k] < 10){
            rubikString += "0" + grid[i][j][k];
          }
          else{
            rubikString += grid[i][j][k];
          }
        }
      }
      rubikString += "\n";
    }
    
    for(int a = 4; a < 6; a++){
      for(int i = 0; i < 3; i++){
        rubikString += "......";
        for(int j = 0; j < 3; j++){
          if(grid[a][i][j] < 10){
            rubikString += "0" + grid[a][i][j];
          }
          else{
            rubikString += grid[a][i][j];
          }
        }
        rubikString += "......" + "\n";
      }
    }
    return rubikString;
  }
}