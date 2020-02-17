import java.util.Scanner;
import java.util.Arrays;

class Spelling {
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		Letter[] letters = new Letter[27];

		letters[0] = new Letter(' ', "0", 0);
		letters[1] = new Letter('a', "2", 2);
		letters[2] = new Letter('b', "22", 2);
		letters[3] = new Letter('c', "222", 2);
		letters[4] = new Letter('d', "3", 3);
		letters[5] = new Letter('e', "33", 3);
		letters[6] = new Letter('f', "333", 3);
		letters[7] = new Letter('g', "4", 4);
		letters[8] = new Letter('h', "44", 4);
		letters[9] = new Letter('i', "444", 4);
		letters[10] = new Letter('j', "5", 5);
		letters[11] = new Letter('k', "55", 5);
		letters[12] = new Letter('l', "555", 5);
		letters[13] = new Letter('m', "6", 6);
		letters[14] = new Letter('n', "66", 6);
		letters[15] = new Letter('o', "666", 6);
		letters[16] = new Letter('p', "7", 7);
		letters[17] = new Letter('q', "77", 7);
		letters[18] = new Letter('r', "777", 7);
		letters[19] = new Letter('s', "7777", 7);
		letters[20] = new Letter('t', "8", 8);
		letters[21] = new Letter('u', "88", 8);
		letters[22] = new Letter('v', "888", 8);
		letters[23] = new Letter('w', "9", 9);
		letters[24] = new Letter('x', "99", 9);
		letters[25] = new Letter('y', "999", 9);
		letters[26] = new Letter('z', "9999", 9);

		int input = sc.nextInt();
		sc.nextLine();

		for(int i = 0; i < input; i++){
			int num = i+1;
			String output = "Case #" + num + ": ";
			String words = sc.nextLine();
			int temp = 10;
			for(int j = 0; j < words.length(); j++){
				for(int k = 0; k < 27; k++){
					if(words.charAt(j) == letters[k].getAlphabet()){
						if(j != 0 && (temp == letters[k].getGroup())){
							output += ' ' + letters[k].getValue();
							temp = letters[k].getGroup();
							break;
						}
						else{
							output += letters[k].getValue();
							temp = letters[k].getGroup();
							break;
						}
					}
				}
			}
			System.out.println(output);
		}
	}
}

class Letter {

	private char alphabet;
	private String value;
	private int group;

	public Letter(char alphabet, String value, int group) {
		this.alphabet = alphabet;
		this.value = value;
		this.group = group;
	}

	public char getAlphabet() {
		return alphabet;
	}

	public String getValue() {
		return value;
	}

	public int getGroup() {
		return group;
	}
}
