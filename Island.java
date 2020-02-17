import java.util.*;
import java.io.*;
import java.lang.*;

class Island {
	public static void main(String[] args) {
		Kattii io = new Kattii(System.in, System.out);

		int rows = io.getInt();
		int columns = io.getInt();
		int lands = 0;

		char[][] grid = new char[rows][columns];
		int[][] visited = new int[rows][columns];

		//input data
		for(int i = 0; i < rows; i++) {
			String letters = io.getWord();
			for(int j = 0; j < columns; j++) {
				grid[i][j] = letters.charAt(j);
				visited[i][j] = 0;
			}
		}

		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(grid[i][j] == 'L' && visited[i][j] != 1) {
					visited[i][j] = 1;
					Deque<Pair> plots = new ArrayDeque<Pair>();
					plots.add(new Pair(i, j));
					lands++;
					while(plots.size() > 0) {
						Pair plot = plots.pollFirst();
						int row = plot.row;
						int col = plot.col;
						if(row-1 > -1 && (grid[row-1][col] == 'C' || grid[row-1][col] == 'L') && visited[row-1][col] != 1) {
							plots.add(new Pair(row-1, col));
							visited[row-1][col] = 1;
						}
						if(row+1 < rows && (grid[row+1][col] == 'C' || grid[row+1][col] == 'L') && visited[row+1][col] != 1) {
							plots.add(new Pair(row+1, col));
							visited[row+1][col] = 1;
						}
						if(col-1 > -1 && (grid[row][col-1] == 'C' || grid[row][col-1] == 'L') && visited[row][col-1] != 1) {
							plots.add(new Pair(row, col-1));
							visited[row][col-1] = 1;
						}
						if(col+1 < columns && (grid[row][col+1] == 'C' || grid[row][col+1] == 'L') && visited[row][col+1] != 1) {
							plots.add(new Pair(row, col+1));
							visited[row][col+1] = 1;
						}
					}
				}
				if(grid[i][j] != 'C') {
					visited[i][j] = 1;
				}
			}
		}
		io.println(lands);
		io.close();

		//while(plots.size() > 0) {
		//	Pair plot = plots.pollFirst();
		//}

		//for(int i = 0; i < rows; i++) {
		//	for(int j = 0; j < columns; j++) {
		//		System.out.print(grid[i][j]);
		//	}
		//	System.out.println();
		//}

		/*UnionFindDS ufds = new UnionFindDS(rows*columns);
		boolean firstWater = true;
		int waterParent = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(grid[i][j] == 'L') {
					if(i-1 >= 0 && grid[i-1][j] == 'L') {
						ufds.unionSet((i*columns)+j, (((i-1)*columns))+j);
						//System.out.println("up");
					}
					if(j-1 >= 0 && grid[i][j-1] == 'L') {
						ufds.unionSet((i*columns)+j, (i*columns)+(j-1));
						//System.out.println("left");
					}
					if(i+1 <= rows-1 && grid[i+1][j] == 'L') {
						ufds.unionSet((i*columns)+j, ((i+1)*columns)+j);
						//System.out.println("down");
					}
					if(j+1 <= columns-1 && grid[i][j+1] == 'L'){
						ufds.unionSet((i*columns)+j, (i*columns)+(j+1));
						//System.out.println("right");
					}
				}
				else {
					if(firstWater) {
						waterParent = (i*columns)+j;
						firstWater = false;
						//System.out.println("parent " + waterParent);
					}
					else {
						ufds.unionSet((i*columns)+j, waterParent);
						//System.out.println("child " + waterParent);
						//System.out.println();
					}
				}
				//System.out.println("sets " + ufds.numDisjointSets());
			}
		}
		int numLand = ufds.numDisjointSets()-1;
		io.println(numLand);
		io.close();*/
	}
}

class Pair {
	public int row;
	public int col;
	public Pair (int row, int col){
		this.row = row;
		this.col = col;
	}
}

/*class UnionFindDS {                                              
  public int[] p;
  public int[] rank;
  public int numSets;

  public UnionFindDS(int N) {
    p = new int[N];
    rank = new int[N];
    numSets = N;
    for (int i = 0; i < N; i++) {
      p[i] = i;
      rank[i] = 0;
    }
  }

  public int findSet(int i) { 
    if (p[i] == i) return i;
    else {
      p[i] = findSet(p[i]);
      return p[i]; 
    } 
  }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { 
      numSets--; 
      int x = findSet(i), y = findSet(j);
      // rank is used to keep the tree short
      if (rank[x] > rank[y]) 
      	p[y] = x;
      else { 
      	p[x] = y;
        if (rank[x] == rank[y]) 
          rank[y] = rank[y]+1; 
      } 
    } 
  }

  public int numDisjointSets() { return numSets; }
}*/

class Kattii extends PrintWriter {
    public Kattii(InputStream i) {
       	super(new BufferedOutputStream(System.out));
       	r = new BufferedReader(new InputStreamReader(i));
   	}
   	public Kattii(InputStream i, OutputStream o) {
       	super(new BufferedOutputStream(o));
       	r = new BufferedReader(new InputStreamReader(i));
   	}

   	public boolean hasMoreTokens() {
       	return peekToken() != null;
   	}

   	public int getInt() {
       	return Integer.parseInt(nextToken());
   	}

   	public double getDouble() {
       	return Double.parseDouble(nextToken());
   	}

   	public long getLong() {
       	return Long.parseLong(nextToken());
   	}

   	public String getWord() {
       	return nextToken();
   	}

   	private BufferedReader r;
   	private String line;
   	private StringTokenizer st;
   	private String token;

   	private String peekToken() {
       	if (token == null)
           	try {
               	while (st == null || !st.hasMoreTokens()) {
                   	line = r.readLine();
                   	if (line == null) return null;
                   	st = new StringTokenizer(line);
               	}
               	token = st.nextToken();
           	} catch (IOException e) { }
       	return token;
   	}

   	private String nextToken() {
       	String ans = peekToken();
       	token = null;
       	return ans;
   	}
}