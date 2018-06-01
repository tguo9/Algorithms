
public class ArrayStack implements Stack {

	//Data members.
	private int top;
	private Object[] arr;
	public static final int DEFAULT_INITIAL_SIZE = 100;

	//Constructor.
	public ArrayStack() {
		arr = new Object[DEFAULT_INITIAL_SIZE];
		top = 0;
	}

	//Puts the argument on the top of the stack.
	public void push(Object item) {

		//Check full.
		if (top == arr.length) {

			growStack();
		}
		arr[top++] = item;

	}

	//Removes & returns the Object at the top of the stack.
	public Object pop() {
		
		//Check empty.
		if (!empty()) {

			return arr[--top];
		}
		return null;
	}

	//Returns a copy of the top of the stack.
	public Object peek() {

		//Check empty.
		if (!empty()) {

			return arr[top - 1];
		}

		return null;
	}

	//Returns true if nothing is on the stack.
	public boolean empty() {
		if (top == 0) {

			return true;
		} else {

			return false;
		}
	}

	//Resize the array.
	private void growStack() {

		Object[] temp = new Object[arr.length * 2];

		System.arraycopy(arr, 0, temp, 0, arr.length);
		arr = temp;
	}

}
