import java.util.*;
import java.lang.*;
import java.io.*;

class KattisQuest {
	public static void main(String[] args) {
		Kattioe io = new Kattioe(System.in, System.out);

		TreeMap<Long, PriorityQueue<Long>> tm = new TreeMap<>();
		int input = io.getInt();

		for(int i = 0; i < input; i++) {
			String command = io.getWord();
			if(command.equals("add")) {//If command is add
				long key = io.getLong();
				long value = io.getLong();
				if(tm.containsKey(key)) {
					PriorityQueue<Long> pq = tm.get(key);
					pq.add(value);
					tm.put(key, pq);
					//System.out.println(tm.toString());
				}
				else {
					PriorityQueue<Long> pq = new PriorityQueue<Long>(new RewardComparator());
					pq.add(value);
					tm.put(key, pq);
					//System.out.println(tm.toString());
				}
			}
			else {//If command is query
				long energy = io.getLong();
				long total = 0;
				if(tm.size() == 0) {
					total = 0;
				}
				else {
					while(energy >= tm.firstKey() && energy > 0) {
						long tempKey = tm.floorKey(energy);
						PriorityQueue<Long> pq = tm.get(tempKey);
						total += pq.poll();
						if(pq.size() > 0) {
							tm.put(tempKey, pq);
							//System.out.println(tm.toString());
						}
						else {
							tm.remove(tempKey);
							//System.out.println(tm.toString());
						}
						energy = energy - tempKey;
						if(tm.size() == 0) {
							break;
						}
					}
				}
				System.out.println(total);
			}
		}
		io.close();
	}
}

class RewardComparator implements Comparator<Long> {
	public int compare (Long a, Long b) {
		if(a < b) {
			return 1;
		}
		else if(a > b) {
			return -1;
		}
		else {
			return 0;
		}		
	}
}

class Kattioe extends PrintWriter {
    public Kattioe(InputStream i) {
       	super(new BufferedOutputStream(System.out));
       	r = new BufferedReader(new InputStreamReader(i));
   	}
   	public Kattioe(InputStream i, OutputStream o) {
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