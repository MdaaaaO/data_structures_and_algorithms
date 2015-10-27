package stack;

import stack.StackEmptyException;
import stack.StackFullException;

/**
 * Exercise 1.a - Stack Implementation as an Array with Exception-Handling
 * 
 * @author Georg Kasper
 * @date 10/21/2015
 */
public class MyArrayStack extends Stack {
	private int array_size = 16;
	private Object[] intern_array = new Object[this.array_size];
	private int intern_index = -1;
	
	@Override
	public String version() {
		return "1.a - Stack Implementation as an Array with Exception-Handling";
	}

	@Override
	public void empty() {
		this.intern_index = -1;
	}

	@Override
	public void push(Object element) throws StackFullException {
		if (this.intern_index == this.array_size - 1) {
			throw new StackFullException("You can't push to a full stack.");
		} else {
			this.intern_index++;
			this.intern_array[intern_index] = element;
		}
	}

	@Override
	public Object pop() throws StackEmptyException {
		if (this.intern_index == -1) {
			throw new StackEmptyException("You can't pop an empty stack.");
		} else {
			Object element = this.intern_array[this.intern_index];
			this.intern_index--;
			return element;
		}
	}

	@Override
	public int size() {
		return this.intern_index + 1;
	}

	@Override
	public boolean isEmpty() {
		if (this.intern_index == -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if (this.intern_index + 1  == this.array_size) {
			// with a size of 1024, the last index will be 1023
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object peek() throws StackEmptyException {
		if (this.intern_index == -1) {
			throw new StackEmptyException("You can't peek an empty stack.");
		} else {
			return this.intern_array[this.intern_index];
		}
	}

	@Override
	public String toString() {
		
		String toString = new String();
		if (this.intern_index == -1) {
			toString = "NULL";
		} else {
			for (int i = 0; i < this.intern_index; i++) {
				toString += this.intern_array[i].toString() + ", ";
			}
			toString += "[" + this.intern_array[this.intern_index].toString() + "]";
		}
		return toString;
	}

}
