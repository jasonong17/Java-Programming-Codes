import java.util.*;
import java.lang.*;
import java.io.*;

class Conformity {
	public static void main(String[] args) {
		Kattios io = new Kattios(System.in, System.out);

		int num = io.getInt();
		List<Courses> courses = new ArrayList<Courses>();
		int popular = 0;
		int winners = 0;

		for(int i = 0; i < num; i++) {

			int[] tempCourses = new int[5];
			boolean noMatch = true;

			for(int j = 0; j < 5; j++) {
				tempCourses[j] = io.getInt();
			}

			if(i == 0) {
				Arrays.sort(tempCourses);
				courses.add(new Courses(tempCourses));
				courses.get(courses.size()-1).addFreq();
			}
			else {
				Arrays.sort(tempCourses);
				for(Courses c : courses) {
					if(Arrays.equals(tempCourses, c.getCourses())){
						c.addFreq();
						noMatch = false;
						break;
					}
				}
				if(noMatch) {
					Arrays.sort(tempCourses);
					courses.add(new Courses(tempCourses));
					courses.get(courses.size()-1).addFreq();
				}
			}
		}

		for(Courses c : courses) {
			popular = Math.max(c.getFreq(), popular);
		}
		for(Courses c : courses) {
			if(c.getFreq() == popular) {
				winners += popular;
			}
		}
		System.out.println(winners);
		io.close();
	}
}

class Courses {

	public int[] courses = new int[5];
	public int frequency = 0;

	public Courses(int[] tempCourses) {
		for(int i = 0; i < 5; i++) {
			courses[i] = tempCourses[i];
		}
	}

	public void addFreq() {
		frequency++;
	}
	public int getFreq() {
		return frequency;
	}
	public int[] getCourses() {
		return courses;
	}
}

class Kattios extends PrintWriter {
    public Kattios(InputStream i) {
       	super(new BufferedOutputStream(System.out));
       	r = new BufferedReader(new InputStreamReader(i));
   	}
   	public Kattios(InputStream i, OutputStream o) {
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