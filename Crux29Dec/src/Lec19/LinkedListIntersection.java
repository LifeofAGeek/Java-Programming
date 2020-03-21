package Lec19;

class Node {
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
	
	Node(){
		
	}
}

public class LinkedListIntersection {

	public static void main(String[] args) {
		
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		Node n9 = new Node(90);
		Node n10 = new Node(100);
		Node n11 = new Node(110);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = null;
		
		n8.next = n9;
		n9.next = n10;
		n10.next = n11;
		n11.next = n4;
		
		Node h1 = n1;
		Node h2 = n8;
		
		System.out.println(getIntersection(h1, h2));
		
	}
	
	public static Node getIntersection(Node h1, Node h2) {
		
		Node a_pointer = h1;
		Node b_pointer = h2;
		
		while(a_pointer != b_pointer) {
			
			if(a_pointer == null)
				a_pointer = h2;
			else
				a_pointer = a_pointer.next;
			
			if(b_pointer == null)
				b_pointer = h1;
			else
				b_pointer = b_pointer.next;
			
		}
		
		return a_pointer;
		
		
	}
	
	

}
