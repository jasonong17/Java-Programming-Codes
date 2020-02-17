import java.util.Scanner;

public class TrainPassengers {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int totalCapacity = sc.nextInt();
		int stations = sc.nextInt();

		boolean isPossible = true;
		int peopleTotal = 0;

		for(int i = 0; i < stations; i++){
			int peopleLeft = sc.nextInt();
			int peopleEnter = sc.nextInt();
			int peopleStay = sc.nextInt();

			if(i == 0){
				peopleTotal = peopleEnter;
				if(peopleLeft > 0){
					isPossible = false;
					break;
				}
				else if((totalCapacity - peopleTotal) > 0 && peopleStay > 0){
					isPossible = false;
					break;
				}
				else if(peopleTotal > totalCapacity){
					isPossible = false;
					break;
				}
				else if(peopleTotal < 0){
					isPossible = false;
					break;
				}
				else{
				}
			}
			else if(i == stations-1){
				peopleTotal = peopleTotal - peopleLeft;
				if(peopleEnter > 0 || peopleStay > 0 || peopleTotal != 0){
					isPossible = false;
					break;
				}
				else if(peopleTotal < 0){
					isPossible = false;
					break;
				}
				else{
				}
			}
			else{
				peopleTotal = peopleTotal + peopleEnter - peopleLeft;
				if(peopleTotal > totalCapacity){
					isPossible = false;
					break;
				}
				else if((totalCapacity - peopleTotal) > 0 && peopleStay > 0){
					isPossible = false;
					break;
				}
				else if(peopleTotal < 0){
					isPossible = false;
					break;
				}
				else{
				}
			}
		}

		if(isPossible){
			System.out.println("possible");
		}
		else{
			System.out.println("impossible");
		}
	}
}