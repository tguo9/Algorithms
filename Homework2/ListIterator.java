/* This is the interface for the ListIterator. Can be used in other class.
 * @author Tao Guo
 */

public interface ListIterator {
	
	// returns “true” if there is an Object after the current location
	public boolean hasNext();

	// advances to the next Object instance and returns a copy of that Object
	public Object next();

}
