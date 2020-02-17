import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

class BestRelay {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int totalRunner = sc.nextInt();
		sc.nextLine();
		PriorityQueue<Runner> flyRunners = new PriorityQueue<Runner>(new RunTimeComparator());
		PriorityQueue<Runner> startRunners = new PriorityQueue<Runner>(new StartTimeComparator());
		List<Runner> selectedFlyRunners = new ArrayList<Runner>();
		List<Runner> selectedStartRunners = new ArrayList<Runner>();
		String[] potentialRunners = new String[4];
		String[] finalRunners = new String[4];

		for(int i = 0; i < totalRunner; i++) {
			String name = sc.next();
			double startTime = sc.nextDouble();
			double runTime = sc.nextDouble();

			Runner runner = new Runner(name, startTime, runTime);
			flyRunners.add(runner);
			startRunners.add(runner);
		}

		for(int i = 0; i < totalRunner; i++){
			selectedFlyRunners.add(flyRunners.poll());
		}

		for(int i = 0; i < totalRunner; i++){
			selectedStartRunners.add(startRunners.poll());
		}
		
		
		double minTime = 0;
		int i = 0;
		
		for(Runner r1 : selectedStartRunners){
			double totalTime = r1.getStart();
			potentialRunners[0] = r1.getName();
			int k = 1;
			
			for(Runner r2 : selectedFlyRunners){
				if(!r1.equals(r2)){
					totalTime += r2.getRun();
					potentialRunners[k] = r2.getName();
					if(k == 3){
						break;
					}
					k++;
				}
			}
			if(i == 0){
				minTime = totalTime;
				for(int count = 0; count < 4; count++){
					finalRunners[count] = potentialRunners[count];
				}
				i++;
			}
			else{
				if(totalTime < minTime){
					minTime = totalTime;
					for(int count = 0; count < 4; count++){
						finalRunners[count] = potentialRunners[count];
					}
				}
			}	
		}

		System.out.println(minTime);
		for(int j = 0; j < 4; j++){
			System.out.println(finalRunners[j]);
		}

	}
}

class RunTimeComparator implements Comparator<Runner> {
	public int compare(Runner runner1, Runner runner2) {
		return runner1.getRun() < runner2.getRun() ? -1 : 1;
	}
}

class StartTimeComparator implements Comparator<Runner> {
	public int compare(Runner runner1, Runner runner2) {
		return runner1.getStart() < runner2.getStart() ? -1 : 1;
	}
}

class Runner {

	private String name;
	private double startTime;
	private double runTime;

	public Runner(String name, double startTime, double runTime) {
		this.name = name;
		this.startTime = startTime;
		this.runTime = runTime;
	}

	public String getName() {
		return name;
	}

	public double getStart() {
		return startTime;
	}

	public double getRun() {
		return runTime;
	}
}