import java.util.*;
import java.lang.*;
import java.io.*;

class Millionaire {
	public static void main(String[] args) {
		Kattip io = new Kattip(System.in, System.out);

		int row = io.getInt();
		int col = io.getInt();

		int[][] map = new int[row][col];
		int[][] visited = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				map[i][j] = io.getInt();
				visited[i][j] = 0;
			}
		}

		PriorityQueue<Four> edges = new PriorityQueue<Four>(new edgeComparator());
		int ladder = 0;
		edges.add(new Four(0, 0, map[0][0], 0));
		visited[0][0] = 1;

		while(visited[row-1][col-1] == 0 && !edges.isEmpty()) {
			Four edge = edges.poll();
			int x = edge.x;
			int y = edge.y;
			int height = edge.height;
			int diff = edge.diff;
			visited[x][y] = 1;
			if(diff < ladder) {
				ladder = diff;
			}

			if(x-1 > -1 && visited[x-1][y] == 0) {
				int diffUp = height - map[x-1][y];
				edges.add(new Four(x-1, y, map[x-1][y], diffUp));
			}
			if(x+1 < row && visited[x+1][y] == 0) {
				int diffDown = height - map[x+1][y];
				edges.add(new Four(x+1, y, map[x+1][y], diffDown));
			}
			if(y-1 > -1 && visited[x][y-1] == 0) {
				int diffLeft = height - map[x][y-1];
				edges.add(new Four(x, y-1, map[x][y-1], diffLeft));
			}
			if(y+1 < col && visited[x][y+1] == 0) {
				int diffRight = height - map[x][y+1];
				edges.add(new Four(x, y+1, map[x][y+1], diffRight));
			}
		}
		io.println(Math.abs(ladder));
		io.close();
	}
}

class Four {
	public int x;
	public int y;
	public int height;
	public int diff;
	public Four (int x, int y, int height, int diff){
		this.x = x;
		this.y = y;
		this.height = height;
		this.diff = diff;
	}
}

class edgeComparator implements Comparator<Four>{
	public int compare(Four t1, Four t2) {
		if(t1.diff > t2.diff) {
			return -1;
		}
		else if(t1.diff < t2.diff) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

class Kattip extends PrintWriter {
    public Kattip(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattip(InputStream i, OutputStream o) {
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