package geeksforgeeks;

public class AllDivisor {

	public static void main(String[] args) {

		System.out.println("All Divisor of 25:");
		allDivisorNaive(25);
		System.out.println("All Divisor of 54:");
		allDivisorOptimize(54);
	}
	
	public static void allDivisorNaive(int n) {
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				System.out.println(i);
			}
		}
	}
	
	public static void allDivisorOptimize(int n) {
		int i;
		for(i=1;i*i<=n;i++) {
			if(n%i==0)
				System.out.println(i);
		}
		
		for(;i>=1;i--) {
			if(n%i==0)
				System.out.println(n/i);
		}
	}
}
