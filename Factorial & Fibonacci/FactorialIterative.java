/* This is a class to using iterative to calculate the factorial
 * @author Tao Guo
 */

package edu.usfca.cs.cs245;

public class FactorialIterative implements Factorial {
	
	public int factorial(int n) {
		//Initial variable.
		int result = 1;
		
		//Do the step when n > 1, if n < 1, just return result.
		if(n > 1) {
			while(n > 1) {
				result *= n;
				n--;
			}
		}
		
		//Return result.
		return result;
	}
}