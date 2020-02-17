import java.util.*;

class CardTrick {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();

		for(int i = 0; i < cases; i++){
			Deque<Integer> cards = new ArrayDeque<Integer>();
			int numCards = sc.nextInt();
			while(numCards > 0){
				cards.addFirst(numCards);
				for(int j = 0; j < numCards; j++){
					int card = cards.pollLast();
					cards.addFirst(card);
				}
				numCards--;
			}
			int size = cards.size();
			for(int k = 0; k < size; k++){
				if(k == size-1){
					System.out.println(cards.pollFirst());
				}
				else{
					System.out.print(cards.pollFirst() + " ");
				}
			}
		}
	}
}