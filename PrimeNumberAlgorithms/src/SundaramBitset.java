import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.BitSet;

public class SundaramBitset {

	public static void main(String[] args) {

		// Program start time
		long start = System.currentTimeMillis();

		// Save the result of running the algorithm to a String
		String results = Sundaram(500000);
		
		// Write the result to a text file
		try {
			FileWriter fw = new FileWriter("SundaramResultBitset.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.write(results);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// End time of the program
		long end = System.currentTimeMillis();

		// Print how long it took to run
		System.out.println("The Sieve of Sundaram took " + (end - start) + " milliseconds to run");
	}

	/*
	 * Method for finding prime numbers using the algorithm the Sieve of Sundaram
	 */
	public static String Sundaram(long range) {

		// The "floor" of the algorithm is half the size of the range that gets
		// passed into it
		long floor = (range) / 2;
		String result = "";	// For saving the prime numbers

		//Array of bits initialized as false for keeping track of the prime numbers
		BitSet primes = new BitSet((int) floor);

		// Implementation of the sieve of Sundaram filters out all indexes
		// whose values of the form 2*index + 1 are non-prime odd numbers
		// by setting the appropriate index to true in the bitset array
		for (long i = 1; i <= floor; i++) {
			for (long j = i; j + i + 2 * i * j <= floor; j++) {
				primes.set((int) (j + i + 2 * i * j) );
			}
		}

		// Counter for formatting the numbers
		int count = 0;

		// Add 2 to the result if the range is two or greater and increment the prime number count
		if (range >= 2) {
			result += (2 + "\t");
			count++;
		}

		// Loop through the array and add the prime numbers to a string
		for (int i = 1; i <= floor; i++) {

			// If the computation is within the original range, proceed to add the prime # to the string result
			if((2*i + 1) <= range) {
				
				// If the value at the current index is still false, 2* + 1 will be a prime
				if (!primes.get(i)) {
	
					// Increment the prime number counter
					count++;
	
					// Add the value to the string
					result += (2 * i + 1 + "\t");
	
					// If there is a multiple of ten, add a new line
					if (count % 10 == 0)
						result += "\n";
				}
			}
		}
		return result;
	}
}