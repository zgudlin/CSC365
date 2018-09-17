import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.BitSet;

public class EratosthenesBitset {
	
	public static void main(String[] args) {
	
		// Program start time
		long start = System.currentTimeMillis();

		// Save the result of running the algorithm to a String
		String results = Eratosthenes(500000);
		
		// Write the result to a text file
		try {
			FileWriter fw = new FileWriter("EratosthenesResultBitset.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.write(results);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// End time of the program
		long end = System.currentTimeMillis();
		
		// Display how long it took to run
		System.out.println("The Sieve of Eratosthenes took " + (end - start) + " milliseconds to run");
	}
	
	/*
	 * Method for finding prime numbers using the algorithm the Sieve of Eratosthenes
	 */
	public static String Eratosthenes(long range) {
		
		// For returning the result
		String result = "";
		
		//Array of bits initialized as false for keeping track of the prime numbers
		BitSet primes = new BitSet((int) (range + 1));
		
		// Implementation of the sieve of Eratosthenes filters out all numbers
		// in a given range that can be expressed as a multiple of any integer 
		// greater than 1
		for(int prime = 2; prime * prime <= range; prime++) {

			// Set an index to equal twice the value of the current value being checked
			for(int j = prime + prime; j <= range; j += prime) {

				// Set the current index in the bitset array to true to indicate it is not prime
				primes.set(j);
			}
		}

		// Counter for formatting the numbers
		int count = 0;

		// Loop through the array and add the prime numbers to a string
		for (int index = 2; index <= range; index++) {

			// If the indexed value of the array is false, the index is prime
			if (!primes.get(index)) {

				// Increment the prime number counter
				count++;

				// Add value to result
				result += index + "\t";

				// If there is a multiple of ten, add a new line
				if (count % 10 == 0)
					result += "\n";
			}
		}
		return result;
	}
}