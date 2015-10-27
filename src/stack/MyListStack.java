package stack;

/**
 * Exercise 1.b - Stack Implementation as a linked List with Exception-Handling.
 * 
 * @author Georg Kasper
 * @date   10/22/2015	
 */
public class MyListStack extends Stack {
	
	private Link myTop = null;
	private int size = -1;

	@Override
	public String version() {
		return "Exercise 1.b - Stack Implementation as a linked List with Exception-Handling.";
	}

	/**
	 * We empty the stack by setting the size of this stack to -1, which will
	 * be used in other methods as an indicator whether the stack is empty or
	 * not, also we are setting the Link object to null, which is our start 
	 * condition when we create the MyListStack object. 
	 * 
	 * The garbage collector will collect all the linked Link objects, since 
	 * no pointer is pointing to them anymore and we can start from zero.
	 */
	@Override
	public void empty() {
		this.size = -1;
		this.myTop = null;
	}

	/**
	 * 1. We won't allow to push null elements
	 * 2. If the stack is empty, we will create a new Link Object.
	 * 3. If the stack is not empty, we will insert an new Link Object as the
	 * 	  new TOP and set the old TOP as the next Element.
	 */
	@Override
	public void push(Object element) {
		if (element == null) {
			System.out.println("You can't push null");
		} else if (this.size < 0) {
			Link newTop = new Link(element);
			this.myTop = newTop;
			this.size++; 
		} else {
			Link oldStackTOP = this.myTop;
			this.myTop = new Link(element);
			this.myTop.next = oldStackTOP;
			this.size++; 
		}
	}

	/**
	 * 1. Popping the Stack while the size is < 0, will cause a 
	 *    StackEmptyException
	 * 2. Popping the stack will reduce the size of the stack
	 * 3. Popping the stack will set the next Element of the stack as the new
	 *    top element of the stack.
	 */
	@Override
	public Object pop() throws StackEmptyException {
		if (this.size < 0) {
			throw new StackEmptyException("You can't pop an empty stack.");
		} else {
			Object top = this.myTop.data;
			this.myTop = this.myTop.next;
			this.size--;
			return top;
		}
	}

	@Override
	public int size() {
		return this.size + 1;
	}

	@Override
	public boolean isEmpty() {
		return this.size + 1 == 0;
	}
	
	/**
	 * Peeking the stack will return the top element of the stack without 
	 * removing it from the stack.
	 */
	@Override
	public Object peek() throws StackEmptyException {
		if (this.size < 0) {
			throw new StackEmptyException("You can't peek an empty stack.");
		} else {
			return this.myTop.data;
		}
	}

	@Override
	public String toString() {
		if (this.size < 0) {
			return "The stack is empty!";
		} else {
			String someString = "";
			Link someLink = this.myTop;
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
}
