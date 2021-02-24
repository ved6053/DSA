package geeksforgeeks.maths;

public class TrailZeroInFactorial {

	public static void main(String[] args) {
		
		System.out.println("trailZeroInFact(5):"+trailZeroInFactNaive(5));
		System.out.println("trailZeroInFact(100):"+trailZeroInFactFiveFactors(100));
	}
	
	public static int trailZeroInFactNaive(int n) {
		long fact = 1;
		for(int i=1;i<=n;i++)
			fact*=i;
		int res=0;
		
		while(fact%10==0) {
			res++;
			fact = fact/10;
		}
		return res;
	}
	
	public static int trailZeroInFactFiveFactors(int n) {
		
		int res = 0;
//		int fiveFactor = 5;
//		while(fiveFactor<n) {
//			res = res + n/fiveFactor;
//			fiveFactor*=5;
//		}
		
		for(int i=5;i<=n; i*=5)
			res+=n/i;
		
		return res;
	}

}
