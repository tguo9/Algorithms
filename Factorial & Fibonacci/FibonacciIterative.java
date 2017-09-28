/* This is a class to using iterative to calculate Fibonacci
 * @author Tao Guo
 */

package edu.usfca.cs.cs245;

public class FibonacciIterative implements Fibonacci{

	public int fibonacci(int n) {
		//Initial three variables.
		int result = 1;
		int previousResult = 1;
		int nextResult = 1;
		
		//While loop to change value each times.
		while(n > 2) {
			n--;
			nextResult = previousResult;
			previousResult = result;
			result = previousResult + nextResult;
		}
		
		//Return the final result.
		return result;
	}
}