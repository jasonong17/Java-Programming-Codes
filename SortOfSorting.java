import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

class SortOfSorting{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int input  = sc.nextInt();
		sc.nextLine();

		while(input > 0){
			PriorityQueue<Name> names = new PriorityQueue<Name>(input, new NameComparator());
			for(int i = 0; i < input; i++){
				String naming = sc.next();
				Name name = new Name(naming, i);
				names.add(name);
			}
			for(int i = 0; i < input; i++){
				if(i == input-1){
					System.out.println(names.poll().getName() + "\n");
				}
				else{
					System.out.println(names.poll().getName());
				}
			}
			input = sc.nextInt();
			sc.nextLine();
		}
	}
}

class NameComparator implements Comparator<Name>{
	public int compare(Name name1, Name name2){
		int firstChar1 = name1.getName().charAt(0);
		int firstChar2 = name2.getName().charAt(0);
		int secondChar1 = name1.getName().charAt(1);
		int secondChar2 = name2.getName().charAt(1);

		if(firstChar1 == firstChar2 && secondChar1 != secondChar2){
			return secondChar1 - secondChar2;
		}
		else if(firstChar1 == firstChar2 && secondChar1 == secondChar2){
			return name1.getCounter() - name2.getCounter();
		}
		else{
			return firstChar1 - firstChar2;
		}
	}
}

class Name{
	private String name;
	private int counter;

	public Name(String name, int counter){
		this.name = name;
		this.counter = counter;
	}

	public String getName(){
		return name;
	}

	public int getCounter(){
		return counter;
	}
}