/* This is a class to using recursive to calculate the factorial
 * @author Tao Guo
 */

package edu.usfca.cs.cs245;

public class FactorialRecursive implements Factorial{

	public int factorial(int n) {
		//Base case, end recursive
		if(n == 1) {

			return 1;
		}
		
		//Recursive call the function
		return n * factorial(n - 1);
	}
}