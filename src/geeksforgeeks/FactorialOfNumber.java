package geeksforgeeks;

public class FactorialOfNumber {
	
	public static void main(String[] args) {
		
		System.out.println("Fact(9):"+factItr(9));
		System.out.println("Fact(5):"+factItr(5));
	}
	
	private static long factItr(int n) {
		long fact = 1;
		for(int i=1;i<=n;i++)
			fact *= i;
		return fact;
	}
	
	private static long factRec(int n) {
		if(n==0||n==1)
			return 1;
		return n*factRec(n-1);
	}
}
