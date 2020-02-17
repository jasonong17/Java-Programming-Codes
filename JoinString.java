import java.util.*;
import java.lang.*;
import java.io.*;

class JoinString {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);

		int num = io.getInt();
		TailedLinkedList[] words = new TailedLinkedList[num];

		for(int i = 0; i < num; i++) {
			String word = io.getWord();
			words[i] = new TailedLinkedList();
			words[i].addWord(word);
		}

		int lastA = 0;

		for(int i = 0; i < num-1; i++) {
			int a = io.getInt();
			int b = io.getInt();

			words[a-1].addList(words[b-1]);
			lastA = a-1;
		}

		words[lastA].print();

		io.close();
	}
}

class ListNode {
/* attributes */
	public String word;
	public ListNode next;
/* constructors */
	public ListNode(String word) { 
		this(word, null); 
	}

	public ListNode(String word, ListNode n) {
		this.word = word;
		next = n;
	}
/* get the next ListNode */
	public ListNode getNext() { 
		return next; 
	}
/* get the item of the ListNode */
	public String getWord() { 
		return word; 
	}
/* set the item of the ListNode */
	public String setWord(String word) { 
		this.word = word; 
		return word;
	}
/* set the next reference */
	public void setNext(ListNode n) { 
		next = n;
	};
}

class TailedLinkedList {
  // attributes
  public ListNode head;
  public ListNode tail;
  public int num_nodes = 0;

  public int size() {
  	return num_nodes;
  }

  public void addWord(String word) {
  	ListNode node = new ListNode(word);
  	insertWord(node);
  	num_nodes++;
  }

  public void addList(TailedLinkedList tll) {
  	insertList(tll);
  }

  public void insertWord (ListNode node) {
  	node.setNext(head);
  	head = node;
  	tail = head;
  }

  public void insertList(TailedLinkedList tll) {
  	tail.next = tll.head;
  	tll.head = null;
  	tail = tll.tail;
  	num_nodes += tll.size();
  }

  public void print() {
    if (head == null)
      System.out.println("Nothing to print...");
    else {
      ListNode cur = head;
      System.out.print(cur.getWord());
      for (int i=1; i < num_nodes; i++) {
       cur = cur.getNext();
       System.out.print(cur.getWord());
      }
      System.out.println("");
    }
  }
}