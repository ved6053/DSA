package geeksforgeeks;

public class PrimeNumber {
	
	public static void main(String[] args) {
	
		System.out.println("isPrime(1031):"+isPrimeNaive(1031));
		System.out.println("isPrime(231):"+isPrimeOptimize(231));
	}
	
	public static boolean isPrimeNaive(int n) {
		
		if(n==1) return false;
		
		for(int i=2;i*i<n;i++) {
			if(n%i==0)
				return false;
		}
	
		return true;//O(n^(1/2))
	}
	
	public static boolean isPrimeOptimize(int n) {
		if(n==1) return false;
		
		if(n==2 || n==3) return true;
		
		if(n%2 == 0 || n%3 == 0) return false;
		
		for(int i=5; i*i<n; i+=6) {
			if(n%i==0||n%(i+2)==0)
				return false;
		}
		
		return true;
	}
}
