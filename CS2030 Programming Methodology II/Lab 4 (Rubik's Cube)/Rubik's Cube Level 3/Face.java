class Face{

    private int[][] grid = new int[3][3];

    public Face(int[][] grid){
      
      for(int i = 0; i < 3;i++){
        for(int j = 0; j < 3; j++){
          this.grid[i][j] = grid[i][j];
        }
      }
    }

    public Face rotateRight(){
      int[][] newGrid = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                newGrid[j][2-i] = grid[i][j];
            }
        }
        Face newFace = new Face(newGrid);
        return newFace;
    }

    public Face rotateLeft(){
      int[][] newGrid = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                newGrid[2-j][i] = grid[i][j];
            }
        }
        Face newFace = new Face(newGrid);
        return newFace;
    }

    public Face rotateHalf(){
      int[][] newGrid = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                newGrid[2-i][2-j] = grid[i][j];
            }
        }
        Face newFace = new Face(newGrid);
        return newFace;
    }

    public int[][] getGrid(){
      int[][] newGrid = new int[3][3];
      for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          newGrid[i][j] = grid[i][j];
        }
      }
      return newGrid;
    }

    public String toString(){
      String stringFace = "";
      for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          stringFace += "0" + grid[i][j];
        }
        stringFace += "\n";
      }
      return stringFace;
    }
}