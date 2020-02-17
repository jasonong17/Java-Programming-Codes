import java.util.*;
import java.lang.*;
import java.io.*;

class WeakVertices {
	public static void main(String[] args) {
		Kattia io = new Kattia(System.in, System.out);

		int size = io.getInt();
		while(size != -1) {
			int[][] mtx = new int[size][size];
			for(int i = 0; i < size; i ++) {
				for(int j = 0; j < size; j++) {
					mtx[i][j] = io.getInt();
				}
			}
			boolean[] isWeak = new boolean[size];
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(mtx[i][j] == 1) {
						for(int k = 0; k < size; k++) {
							if(mtx[i][k] == 1 && mtx[j][k] == 1) {
								isWeak[i] = true;
								isWeak[j] = true;
								isWeak[k] = true;
							}
						}
					}
				}
			}
			for(int i = 0; i < size; i++) {
				if(isWeak[i] == false) {
					 System.out.print(i + " ");
				}
			}
			System.out.println();
			size = io.getInt();
		}
	}
}

class Kattia extends PrintWriter {
    public Kattia(InputStream i) {
       	super(new BufferedOutputStream(System.out));
       	r = new BufferedReader(new InputStreamReader(i));
   	}
   	public Kattia(InputStream i, OutputStream o) {
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