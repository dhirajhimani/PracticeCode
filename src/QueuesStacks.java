import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueuesStacks {
	
	
	
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new ArrayDeque<>();
	}
	
	Stack<Character> stack;
	Queue<Character> queue;
	
	public void pushCharacter(char c){
		stack.push(c);
	}
	
	public void enqueueCharacter(char c){
		queue.add(c);
	}
	
	public char popCharacter(){
		return stack.pop();
	}
	
	public char dequeueCharacter(){
		return queue.poll();
	}
	
}
