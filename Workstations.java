import java.util.*;
import java.io.*;
import java.lang.*;

class Workstations {
	public static void main(String[] args) {
		Kattioo io = new Kattioo(System.in, System.out);

		int totalResearchers = io.getInt();
		int inactivity = io.getInt();
		int unlockSaved = 0;

		PriorityQueue<Researcher> researchers = new PriorityQueue<Researcher>(new ArrivalComparator());
		PriorityQueue<Integer> workstations = new PriorityQueue<Integer>(new TimeComparator());

		for(int i = 0 ; i < totalResearchers; i++) {
			int arrival = io.getInt();
			int duration = io.getInt();
			researchers.add(new Researcher(arrival, duration));
		}

		for(int i = 0; i < totalResearchers; i++) {
			if(workstations.size() == 0) { //Start with a new workstation
				workstations.add(researchers.peek().getArrival() + researchers.peek().getDuration() + inactivity);
				researchers.poll();
			}
			else { //There are workstations already
				if(researchers.peek().getArrival() < workstations.peek()-inactivity) { //First workstation busy
					workstations.add(researchers.peek().getArrival() + researchers.peek().getDuration() + inactivity);
					researchers.poll();
				}
				else if(researchers.peek().getArrival() >= workstations.peek()-inactivity && researchers.peek().getArrival() <= workstations.peek()) { //First workstation available
					workstations.add(researchers.peek().getArrival() + researchers.peek().getDuration() + inactivity);
					workstations.poll();
					researchers.poll();
					unlockSaved++;
				}
				else if(researchers.peek().getArrival() > workstations.peek()) { //First workstation locked
					int size = workstations.size();
					boolean noMatch = true;
					for(int j = 0; j < size; j++) { //Find an unlocked workstation
						if(researchers.peek().getArrival() >= workstations.peek()-inactivity && researchers.peek().getArrival() <= workstations.peek()) {
							workstations.add(researchers.peek().getArrival() + researchers.peek().getDuration() + inactivity);
							workstations.poll();
							researchers.poll();
							noMatch = false;
							unlockSaved++;
							break;
						}
						else{
							if(researchers.peek().getArrival() < workstations.peek()-inactivity) {
							}
							else {
								workstations.poll();
							}
						}
					}
					if(noMatch) { //Unlock new workstation
						workstations.add(researchers.peek().getArrival() + researchers.peek().getDuration() + inactivity);
						researchers.poll();
					}
				}
			}
		}
		System.out.println(unlockSaved);
	}
}

class Researcher {
	public int arrival;
	public int duration;

	public Researcher(int arrival, int duration) {
		this.arrival = arrival;
		this.duration = duration;
	}

	public int getArrival() {
		return arrival;
	}

	public int getDuration() {
		return duration;
	}
}

class ArrivalComparator implements Comparator<Researcher> {
	public int compare(Researcher r1, Researcher r2) {
		if(r1.getArrival() < r2.getArrival()) {
			return -1;
		}
		else if(r1.getArrival() > r2.getArrival()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

class TimeComparator implements Comparator<Integer> {
	public int compare(Integer int1, Integer int2) {
		if(int1 < int2) {
			return -1;
		}
		else if(int1 > int2) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

class Kattioo extends PrintWriter {
    public Kattioo(InputStream i) {
       	super(new BufferedOutputStream(System.out));
       	r = new BufferedReader(new InputStreamReader(i));
   	}
   	public Kattioo(InputStream i, OutputStream o) {
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