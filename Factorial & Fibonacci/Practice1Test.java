package edu.usfca.cs.cs245;

public class Practice1Test {

	protected A1Factory factory;
	protected String [] types;


	/*
	 * Constructor for the class.
	 */
	public Practice1Test () {
		factory = new A1Factory();
		types = new String [] {"recursive", "iterative"};  // Better to put these in a config file?
	}


	/*
	 * This function tests three sample values of the factorial function.
	 */
	public boolean testFactorial(Factorial fact) {
		int[][] expectedValues = {{1, 1}, {4, 24}, {10, 3628800}};
		long startTime = System.nanoTime();
		for (int i = 0; i < expectedValues.length; i++) {
			if (fact.factorial(expectedValues[i][0]) != expectedValues[i][1])
				return false;
		}
		System.out.println("This function tooks " + measure(startTime)/1000 + " second");
		
		return true;
	}


	/*
	 * This function tests three sample values of the Fibonacci function.
	 */
	public boolean testFibonacci(Fibonacci fib) {
		int[][] expectedValues = {{1, 1}, {4, 3}, {10, 55}};
		long startTime = System.nanoTime();
		for (int i = 0; i < expectedValues.length; i++) {
			if (fib.fibonacci(expectedValues[i][0]) != expectedValues[i][1])
				return false;
		}
		System.out.println("This function tooks " + measure(startTime)/1000 + " second");
		
		return true;
	}
	
	public long measure(long startTime) {
		
		long result = System.nanoTime() - startTime;
		
		return result;
	}

	/*
	 * This function tests the general correctness of the functions we care about.
	 */
	public void testCorrectness() {
		System.out.println("Testing correctness.");
		try {
			for (int i = 0; i < types.length; i++) {
				System.out.print("* Factorial " + types[i] + " tests...");
				if (testFactorial(factory.getFactorial(types[i])))
					System.out.println(" passed.");
				else
					System.out.println(" failed.");
			}
			for (int i = 0; i < types.length; i++) {
				System.out.print("* Fibonacci " + types[i] + " tests...");
				if (testFibonacci(factory.getFibonacci(types[i])))
					System.out.println(" passed.");
				else
					System.out.println(" failed.");
			}
		}
		catch (CannotConstructException cce) {
			System.out.println("Failed to construct the right class.");
		}
	}


	/*
	 * This is a stub for testing the timing.
	 * - Use it to compare recursion vs. iteration.
	 * - Wall clock speed is sufficient for now. 
	 */
	public void testPerformance() {
		System.out.println("Advanced: implement the speed test.");
		}


	/*
	 * main function
	 */
	public static void main(String[] args) {
		Practice1Test test = new Practice1Test();
		
		test.testCorrectness();
		test.testPerformance();
	}

}
