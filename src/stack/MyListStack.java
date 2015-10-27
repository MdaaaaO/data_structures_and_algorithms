package stack;

/**
 * Exercise 1.b - Stack Implementation as a linked List with Exception-Handling.
 * 
 * @author Georg Kasper
 * @date   10/22/2015	
 */
public class MyListStack extends Stack {
	
	private Link myTop = new Link();

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
		if (this.myTop.data == null) {
			this.myTop.data = element;
		} else {
			Link oldStackTOP = this.myTop;
			this.myTop = new Link(element);
			this.myTop.next = oldStackTOP;
			System.out.println("new top " + this.myTop.data.toString());
			System.out.println("prev. top " + oldStackTOP.data.toString());
		}

	}

	@Override
	public Object pop() {
		Object top = this.myTop.data;
		this.myTop = this.myTop.next;
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
		String someString = "";
		Link someLink = this.myTop;
		someString += "[" +  someLink.data.toString() + "] ";
		someLink = someLink.next;
		while (true) {
			someString += someLink.data.toString() + " ";
			if (someLink.next == null) {
				break;
			} else {
				someLink = someLink.next;
			}
		}
		return someString;
	}
}
