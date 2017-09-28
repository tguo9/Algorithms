package edu.usfca.cs.cs245;


public class A1Factory {


	/**
	 * getFactorial
	 * @param factorialType -- "recursive" or "iterative"
	 * @return a "Factorial" implementation.
	 * @throws CannotConstructException
	 */
	Factorial getFactorial(String factorialType) throws CannotConstructException {
		if (factorialType.equalsIgnoreCase("recursive")) {
			return new FactorialRecursive();
		}
		if (factorialType.equalsIgnoreCase("iterative")) {
			return new FactorialIterative();
		}
		throw new CannotConstructException("Invalid type of factorial function " + factorialType);
	}


	/**
	 * getFibonacci
	 * @param fibonacciType -- "recursive" or "iterative"
	 * @return a "Fibonacci" implementation.
	 * @throws CannotConstructException
	 */
	Fibonacci getFibonacci(String fibonacciType) throws CannotConstructException {
		if (fibonacciType.equalsIgnoreCase("recursive")) {
			return new FibonacciRecursive();
		}
		if (fibonacciType.equalsIgnoreCase("iterative")) {
			return new FibonacciIterative();
		}
		throw new CannotConstructException("Invalid type of fibonacci function " + fibonacciType);
	}

}
