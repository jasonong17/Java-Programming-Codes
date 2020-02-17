import java.util.*;
import java.lang.*;
import java.io.*;

class LostMap {
	public static ArrayList<ArrayList <IntegerTriple>> adjList;
	public static ArrayList<Boolean> taken;
	public static PriorityQueue<IntegerTriple> pq;

	public static void process(int source) {
		taken.set(source, true);
		for(int i = 0; i < adjList.get(source).size(); i++) {
			IntegerTriple triple = adjList.get(source).get(i);
			if(!taken.get(triple.dest())) {
				pq.offer(new IntegerTriple(source, triple.dest(), triple.weight()));
			}
			else {
			}
		}
	}

	public static void main(String[] args) {
		Kattiz io = new Kattiz(System.in, System.out);

		int villages = io.getInt();
		int [][] distances = new int[villages][villages];
		adjList = new ArrayList<ArrayList<IntegerTriple>>();

		PriorityQueue<IntegerTriple> result = new PriorityQueue<IntegerTriple>(); 

		for(int i = 0; i < villages; i++) {
			for(int j = 0; j < villages; j++) {
				distances[i][j] = io.getInt();
			}
		}

		for(int i = 0; i < villages; i++) {
			ArrayList<IntegerTriple> triple = new ArrayList<IntegerTriple>();
			adjList.add(triple);
		}

		for(int i = 0; i < villages; i++) {
			for(int j = 0; j < villages; j++) {
				int source = i;
				int dest = j;
				int weight = distances[i][j];
				adjList.get(source).add(new IntegerTriple(source, dest, weight));
			}
		}

		taken = new ArrayList<Boolean>();
		taken.addAll(Collections.nCopies(villages, false));
  		pq = new PriorityQueue<IntegerTriple>();

  		process(0);

  		while(!pq.isEmpty()) {
  			IntegerTriple front = pq.poll();

  			if(!taken.get(front.dest())) {
  				int source = front.source() + 1;
  				int dest = front.dest() + 1;
  				io.println(Math.min(source, dest) + " " + Math.max(source, dest));
  				process(front.dest());
  			}
  			else {
  			}
  		}
  		io.close();
	}
}

class IntegerTriple implements Comparable<IntegerTriple> {
  public Integer _source, _dest, _weight;

  public IntegerTriple(Integer source, Integer dest, Integer weight) {
  	_source = source;
    _dest = dest;
    _weight = weight;
  }

  public int compareTo(IntegerTriple other) {
    if (!this.weight().equals(other.weight())) {
      return this.weight() - other.weight();
    }
    else {
      return this.dest() - other.dest();
    }
  }

  Integer source() { return _source; }

  Integer dest() { return _dest; }

  Integer weight() { return _weight; }
}

class Kattiz extends PrintWriter {
    public Kattiz(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattiz(InputStream i, OutputStream o) {
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