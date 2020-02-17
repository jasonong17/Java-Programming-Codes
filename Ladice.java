import java.util.*;
import java.lang.*;
import java.io.*;

class Ladice {
	public static void main(String[] args) {
		Kattie io = new Kattie(System.in, System.out);

		int items = io.getInt();
		int drawers = io.getInt();

		UnionFind ufds = new UnionFind(drawers); 
		for(int i = 0; i < items; i++) {
			int a = io.getInt()-1;
			int b = io.getInt()-1;
			ufds.unionSet(a, b);
		}
		ufds.getIo().close();
	}
}

class UnionFind {                                              
  public int[] p;
  public int[] rank;
  public int[] size;
  public int[] current;
  public int numSets;
  Kattie io = new Kattie(System.in, System.out);

  public UnionFind(int N) {
    p = new int[N];
    rank = new int[N];
    size = new int[N];
    current = new int[N];
    numSets = N;
    for (int i = 0; i < N; i++) {
      p[i] = i;
      rank[i] = 0;
      size[i] = 1;
      current[i] = 0;
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
      if (rank[x] > rank[y]) {
      	if(size[x] == current[x] && size[y] == current[y]) {
      		io.println("SMECE");
        }
        else {
	      	current[x]++;
	      	size[x] += size[y];
	      	current[x] += current[y];
	      	p[y] = x;
	      	io.println("LADICA");
	      	//size[y] = 0;
	      	//current[y] = 0;
      		//System.out.println("curr" + Arrays.toString(current));
      		//System.out.println("size" + Arrays.toString(size)); 
	      }
      }
      else {
      	if(size[x] == current[x] && size[y] == current[y]) {
      		io.println("SMECE");
        }
        else {
	      	current[y]++;
	      	size[y] += size[x]; 
	      	current[y] += current[x];
	      	p[x] = y;

	        if (rank[x] == rank[y]) {
	          rank[y] = rank[y]+1;
	        }
	        io.println("LADICA");
	        //size[x] = 0;
	      	//current[x] = 0;
      		//System.out.println("curr" + Arrays.toString(current));
      		//System.out.println("size" + Arrays.toString(size)); 
	    }
      }
    }
    else {
    	int x = findSet(i);
    	current[x]++;
    	if(current[x] > size[x]) {
    		current[x]--;
    		io.println("SMECE");
    		//System.out.println("curr" + Arrays.toString(current));
      		//System.out.println("size" + Arrays.toString(size)); 
    	}
    	else {
    		io.println("LADICA");
    		//System.out.println("curr" + Arrays.toString(current));
      		//System.out.println("size" + Arrays.toString(size)); 
    	}
    }
  }

  public int numDisjointSets() { return numSets; }
  public Kattie getIo() { return io; }
}

class Kattie extends PrintWriter {
    public Kattie(InputStream i) {
       	super(new BufferedOutputStream(System.out));
       	r = new BufferedReader(new InputStreamReader(i));
   	}
   	public Kattie(InputStream i, OutputStream o) {
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