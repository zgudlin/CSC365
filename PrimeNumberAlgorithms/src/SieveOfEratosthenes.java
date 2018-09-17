import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SieveOfEratosthenes {
	
	public static void main(String[] args) {
	
		// Program start time
		long start = System.currentTimeMillis();

		// Save the result of running the algorithm to a String
		String results = Eratosthenes(500000);
		
		// Write the result to a text file
		try {
			FileWriter fw = new FileWriter("EratosthenesResult.txt");
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
		
		// Boolean array for indicating whether values corresponding to an index are
		// prime or not
		boolean primeNums[] = new boolean[(int) (range + 1)];

		// Initialize all values to true starting with the index 2
		for (int i = 2; i <= range; i++) {
			primeNums[i] = true;
		}
		
		// Implementation of the sieve of Eratosthenes filters out all numbers
		// in a given range that can be expressed as a multiple of any integer 
		// greater than 1
		for(int prime = 2; prime * prime <= range; prime++) {

			// Set an index to equal twice the value of the current value being checked
			for(int j = prime + prime; j <= range; j += prime) {

				// Set the value at the index to false
				primeNums[j] = false;
			}
		}

		// Counter for formatting the numbers
		int count = 0;

		// Loop through the array and add the prime numbers to a string
		for (int index = 2; index <= range; index++) {

			// If the indexed value is prime
			if (primeNums[index]) {

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
