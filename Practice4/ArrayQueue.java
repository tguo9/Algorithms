
public class ArrayQueue implements Queue {

	//Data members.
	private Object[] arr;
	private int head;
	private int tail;

	//Constructor.
	public ArrayQueue() {
		arr = new Object[10];
		head = 0;
		tail = 0;
	}

	//Add item to the last.
	public void enqueue(Object item) {
		
		//Full check.
		if ((tail + 1) % arr.length == head) {
			growQueue();
		}
		
		//Add item at tail, and update tail.
		arr[tail] = item;
		tail = (tail + 1) % arr.length;

	}

	//Remove item from the top.
	public Object dequeue() {

		//Empty check.
		if (empty()) {
			return null;
		}
		//Remove the head. 
		Object returnVal = arr[head];
		//Update head.
		head = (head + 1) % arr.length;
		
		//Or reset the head.
		if (head == arr.length) {
			head = 0;
		}

		return returnVal;
	}
	
	//If the array is full, resize it.
	private void growQueue() {

		
		Object[] temp = new Object[arr.length * 2];

		System.arraycopy(arr, 0, temp, 0, arr.length);

		arr = temp;
	}

	//Check if the stack is empty.
	public boolean empty() {

		//If it is empty, reset head and tail.
		if (head == tail) {
			head = 0;
			tail = 0;
			return true;
		}
		return false;
	}

}
