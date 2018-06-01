/* This is a class used as a container. Have inner classes.
 * @author Tao Guo
 */

public class LinkedList {

	// Class for the Link of LinkList.
	private class Link {

		private Object element;
		private Link next;

		public Link() {

		}

		public Link(Object newElement) {

			element = newElement;
			next = null;
		}

		public Link(Object newElement, Link newNext) {

			element = newElement;
			next = newNext;
		}

		public Link next() {
			return next;
		}

		public Object element() {
			return element;
		}

		public void setNext(Link newnext) {
			next = newnext;
		}

		public void setElement(Object newElement) {
			element = newElement;
		}
	}

	private Link head;
	private Link tail;
	private int length;

	LinkedList() {
		head = tail = new Link();
		length = 0;
	}

	// adds data to the end of the LinkedList
	public void add(Object data) {
		tail.setNext(new Link(data, null));
		tail = tail.next;
		length++;

	}

	// adds the data parameter to the position in the LinkedList, with the first
	// position being 0
	public void add(int pos, Object data) {

		if (pos <= 0 && pos >= length) {
			System.out.println("Index not in list");
			return;
		}

		Link tmp = head;
		for (int i = 0; i < pos; i++) {
			tmp = tmp.next;
		}
		tmp.next = new Link(data, tmp.next);
		length++;

	}

	// removes the Object stored at position pos
	public void remove(int pos) {
		if (pos <= 0 && pos > length) {
			System.out.println("Index not in list");
			return;
		}
		Link tmp = head;
		for (int i = 0; i < pos; i++) {
			tmp = tmp.next();
		}
		tmp.next = tmp.next.next;
		length--;

	}

	// returns the Object stored at position pos
	public Object get(int pos) {
		if (pos <= 0 && pos > length) {
			System.out.println("Index not in list");
			return null;
		}

		Link tmp = head.next;
		for (int i = 0; i < pos; i++) {
			tmp = tmp.next;
		}
		return tmp.element;
	}

	// returns the size (number of Object instances) of the LinkedList
	public int size() {

		return length;
	}

	public ListIterator ListIterator() {

		return new InnerIterator(0);
	}

	// returns a ListIterator instance, as defined below
	public class InnerIterator implements ListIterator {

		private Link current;

		public InnerIterator(int index) {
			current = head;

			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		}

		@Override
		public boolean hasNext() {
			// returns “true” if there is an Object after the current location
			return current != null && current.next != null;
		}

		@Override
		public Object next() {
			// advances to the next Object instance and returns a copy of that Object
			if (hasNext() == false) {
				System.out.println("No next element");
				return null;
			}
			current = current.next();
			return current.element;
		}

	}
}
