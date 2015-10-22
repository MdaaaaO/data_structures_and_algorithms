package stack;

/**
 * 
 * Exercise 1.b - Stack Implementation as a linked List with Exception-Handling.
 * 
 * @author Georg Kasper
 * @date   10/22/2015	
 */
public class MyListStack extends Stack {
	
	private Link myStack = new Link(" 1 ");

	@Override
	public String version() {
		return "Exercise 1.b - Stack Implementation as a linked List with Exception-Handling.";
	}

	@Override
	public void empty() {
		// TODO Auto-generated method stub
		super.empty();
	}

	@Override
	public void push(Object element) {
		
		Link oldStackTOP = this.myStack;
		this.myStack = new Link(element);
		this.myStack.next = oldStackTOP;
		System.out.println("new top " + this.myStack.data.toString());
	}

	@Override
	public Object pop() {
		Object top = this.myStack.data;
		this.myStack = this.myStack.next;
		System.out.println("returning" + top);
		return top;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return super.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return super.isEmpty();
	}

	@Override
	public boolean isFull() {
		return super.isFull();
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return super.peek();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
