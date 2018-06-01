/* This is a class to using recursive to calculate the Fibonacci
 * @author Tao Guo
 */

package edu.usfca.cs.cs245;

public class FibonacciRecursive implements Fibonacci{

	public int fibonacci(int n) {
		//Base case
		if(n == 0 || n == 1) {

			return n;
		}
		//Recursive call function itself, step case
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}