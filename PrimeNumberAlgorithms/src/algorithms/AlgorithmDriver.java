package algorithms;

public class AlgorithmDriver {

	public static void main(String[] args) {

		Eratosthenes2(15);
		
		//Still does not work right, but is getting closer
		//Sundaram(10);
	}
	
	/*
	 * Method for finding prime numbers using the algorithm the Sieve of
	 * Sundaram
	 */
	public static void Sundaram(long range) {
		
		//The "floor" of the algorithm is half the size of the range that gets 
		//passed into it
		long floor = (range)/2;
		System.out.println(floor);
		
		// Boolean array for indicating whether values corresponding to an index are
		// prime or not
		boolean primeNums[] = new boolean[(int) (floor + 1)];
		
		// Initialize all values to true 
		for (int i = 0; i <= floor; i++) {
			primeNums[i] = true;
		}
		
		//Outer loop 
		for(int i = 0; i <= floor; i ++) {
			for(int j = i; j + i + 2*i*j <= floor; j ++) {
				primeNums[i + j + 2*i*j] = false;
			}
		}
		
		// Counter for formatting the numbers
		int count = 0;
		
		// Display the primes
		
		//Display 2 if the range is two or greater and increment the prime number count
		if(range >= 2) {
			System.out.println(2);
			count ++;
		}

		// Loop through the array and display the prime numbers
		for (int i = 1; i <= floor; i++) {

			// If the indexed value is prime
			if (!primeNums[i]) {

				// Increment the prime number counter
				count++;

				// Display the value
				System.out.print(2*i + 1 + "\t");

				// If there is a multiple of ten, print a new line
				if (count % 10 == 0)
					System.out.println();
			}
		}
		
	}

	/*
	 * Method for finding prime numbers using the algorithm the Sieve of
	 * Eratosthenes
	 */
	public static String Eratosthenes(long range) {
		String result = "";
		// Boolean array for indicating whether values corresponding to an index are
		// prime or not
		boolean primeNums[] = new boolean[(int) (range + 1)];

		// Initialize all values to true starting with the second index
		for (int i = 2; i <= range; i++) {
			primeNums[i] = true;
		}
		// Initialize the first prime number (which is 2)
		int prime = 2;

		// While the square of the prime is less than the range
		while (prime * prime <= range) {

			// Set an index to equal twice the value of the current value being checked for
			// prime
			int j = prime + prime;

			// While the index is less than the range
			while (j <= range) {

				// Set the value at the index to false
				primeNums[j] = false;

				// Increment the index by the current value being used to check for prime
				j += prime;
			}

			// Increment the value for checking if it is a prime number
			prime++;
		}

		// Display the primes

		// Counter for formatting the numbers
		int count = 0;

		// Loop through the array and display the prime numbers
		/*
		 * for(int index = 2; index <= range; index ++) {
		 * 
		 * //If the indexed value is prime if(primeNums[index]) {
		 * 
		 * //Increment the prime number counter count ++;
		 * 
		 * //Display the value System.out.print(index + "\t");
		 * 
		 * //If there is a multiple of ten, print a new line if(count % 10 == 0)
		 * System.out.println(); } }
		 */

		for (int index = 2; index <= range; index++) {

			// If the indexed value is prime
			if (primeNums[index]) {

				// Increment the prime number counter
				count++;

				// Add value to result
				result += index + "\t\t";

				// If there is a multiple of ten, print a new line
				if (count % 10 == 0)
					result += "\n";
			}
		}
		return result;
	}

	public static void Eratosthenes2(long range) {
		String result = "";
		// Boolean array for indicating whether values corresponding to an index are
		// prime or not
		boolean primeNums[] = new boolean[(int) (range + 1)];

		// Initialize all values to true starting with the second index
		for (int i = 2; i <= range; i++) {
			primeNums[i] = true;
		}
		// Initialize the first prime number (which is 2)
		int prime = 2;

		// While the square of the prime is less than the range
		while (prime * prime <= range) {

			// Set an index to equal twice the value of the current value being checked for
			// prime
			int j = prime + prime;

			// While the index is less than the range
			while (j <= range) {

				// Set the value at the index to false
				primeNums[j] = false;

				// Increment the index by the current value being used to check for prime
				j += prime;
			}

			// Increment the value for checking if it is a prime number
			prime++;
		}

		// Display the primes

		// Counter for formatting the numbers
		int count = 0;

		// Loop through the array and display the prime numbers
		for (int index = 2; index <= range; index++) {

			// If the indexed value is prime
			if (primeNums[index]) {

				// Increment the prime number counter
				count++;

				// Display the value
				System.out.print(index + "\t");

				// If there is a multiple of ten, print a new line
				if (count % 10 == 0)
					System.out.println();
			}
		}
	}

}
