import java.util.Scanner;

public class LinkedList {
	public static Node insert(Node head, int data) {
		Node tail = new Node(data);
		if (head == null) {
			return tail;
		}
		Node start = head;
		while (start != null && start.next != null) {
			start = start.next;
		}
		start.next = tail;
		return head;
	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int N = sc.nextInt();

		while (N-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		display(head);
		sc.close();
	}
}

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}
