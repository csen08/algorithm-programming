package programming.recursion;

public class Prime {

	//check if a BigInteger number is prime or not
	//see java.math.BigInteger.isProbablePrime(int certainty)
	
	/**
	 * @see BigInteger::isProbablePrime()
	 * @param bi
	 * @return
	 */
	
	static boolean isPrime(long i) {
		if (i <= 1) return false;
		
		if (i >2 && i%2 == 0) return false;
		
		for (int k=3; k<=Math.sqrt(i)+1;k++) {
			if (i%k==0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPrime(97));
		System.out.println(isPrime(99));
	}
}
