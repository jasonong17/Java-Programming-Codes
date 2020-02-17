import java.util.*;
import java.io.*;
import java.lang.*;

class TenKinds {
	public static void main(String[] args) {
		Kattiv io = new Kattiv(System.in, System.out);

		int row = io.getInt();
		int col = io.getInt();
		int[][] map = new int[row][col];
		int [][] visited = new int[row][col];

		for(int i = 0; i < row; i++) {
			String s = io.getWord();
			for(int j = 0; j < col; j++) {
				int location = Integer.parseInt(Character.toString(s.charAt(j)));
				map[i][j] = location;
				visited[i][j] = 0;
			}
		}

		int query = io.getInt();
		int counter = 1;

		for(int a = 0; a < row; a++) {
			for(int b = 0; b < col; b++) {
				if(map[a][b] == 0) {
					if(visited[a][b] == 0) {
						visited[a][b] = counter;
						Deque<IntPair> area = new ArrayDeque<IntPair>();
						area.add(new IntPair(a, b));
						while(area.size() > 0) {
							IntPair path = area.pollFirst();
							int i = path.row;
							int j = path.col;
		                    if(i-1 > -1 && map[i-1][j] == 0 && visited[i-1][j] == 0) {
								area.add(new IntPair(i-1, j));
								visited[i-1][j] = counter;
							}
							if(i+1 < row && map[i+1][j] == 0 && visited[i+1][j] == 0) {
								area.add(new IntPair(i+1, j));
								visited[i+1][j] = counter;
							}
							if(j-1 > -1 && map[i][j-1] == 0 && visited[i][j-1] == 0) {
								area.add(new IntPair(i, j-1));
								visited[i][j-1] = counter;
							}
							if(j+1 < col && map[i][j+1] == 0 && visited[i][j+1] == 0) {
								area.add(new IntPair(i, j+1));
								visited[i][j+1] = counter;
							}						
						}
						counter++;
					}
				}
				else {
					if(visited[a][b] == 0) {
						visited[a][b] = counter;
						Deque<IntPair> area = new ArrayDeque<IntPair>();
						area.add(new IntPair(a, b));
						while(area.size() > 0) {
							IntPair path = area.pollFirst();
							int i = path.row;
							int j = path.col;
		                    if(i-1 > -1 && map[i-1][j] == 1 && visited[i-1][j] == 0) {
								area.add(new IntPair(i-1, j));
								visited[i-1][j] = counter;
							}
							if(i+1 < row && map[i+1][j] == 1 && visited[i+1][j] == 0) {
								area.add(new IntPair(i+1, j));
								visited[i+1][j] = counter;
							}
							if(j-1 > -1 && map[i][j-1] == 1 && visited[i][j-1] == 0) {
								area.add(new IntPair(i, j-1));
								visited[i][j-1] = counter;
							}
							if(j+1 < col && map[i][j+1] == 1 && visited[i][j+1] == 0) {
								area.add(new IntPair(i, j+1));
								visited[i][j+1] = counter;
							}						
						}
						counter++;
					}					
				}
			}
		}

		for(int i = 0; i < query; i++) {
			int r1 = io.getInt()-1;
			int c1 = io.getInt()-1;
			int r2 = io.getInt()-1;
			int c2 = io.getInt()-1;

			if(map[r1][c1] == 0) {
				if(visited[r1][c1] == visited[r2][c2]) {
					io.println("binary");
				}
				else {
					io.println("neither");
				}
			}
			else {
				if(visited[r1][c1] == visited[r2][c2]) {
					io.println("decimal");
				}
				else {
					io.println("neither");
				}
			}
		}
		io.close();
	}
}

class IntPair {
	public int row;
	public int col;
	public IntPair (int row, int col){
		this.row = row;
		this.col = col;
	}
}

class Kattiv extends PrintWriter {
    public Kattiv(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattiv(InputStream i, OutputStream o) {
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