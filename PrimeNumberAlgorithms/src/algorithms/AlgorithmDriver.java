package algorithms;

public class AlgorithmDriver {

	public static void main(String[] args) {
		
		Eratosthenes(1000);

	}
	
	/*
	 * Method for finding prime numbers using the algorithm
	 * the Sieve of Eratosthenes
	 */
	public static void Eratosthenes(int range) {
		
		//Boolean array for indicating whether values corresponding to an index are prime or not
		boolean primeNums [] = new boolean[range + 1];
		
		//Initialize all values to true starting with the second index
		for(int i = 2; i <= range; i ++) {
			primeNums[i] = true;
		}
		//Initialize the first prime number (which is 2)
		int prime = 2;
		
		//While the square of the prime is less than the range
		while(prime*prime <= range) {
			
			//Set an index to equal twice the value of the current value being checked for prime
			int j = prime + prime; 
			
			//While the index is less than the range
			while(j <= range) {
				
				//Set the value at the index to false
				primeNums[j] = false;
				
				//Increment the index by the current value being used to check for prime
				j += prime;
			}
			
			//Increment the value for checking if it is a prime number
			prime ++;
		}
		
		//Display the primes
		
		//Counter for formatting the numbers
		int count = 0;
		
		//Loop through the array and display the prime numbers
		for(int index = 2; index <= range; index ++) {
			
			//If the indexed value is prime
			if(primeNums[index]) {
				
				//Increment the prime number counter
				count ++;
				
				//Display the value 
				System.out.print(index + "\t");
				
				//If there is a multiple of ten, print a new line
				if(count % 10 == 0) 
					System.out.println();
			}
		}
	}

}
