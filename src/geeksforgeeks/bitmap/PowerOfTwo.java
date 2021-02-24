package geeksforgeeks.bitmap;

public class PowerOfTwo {

	public static void main(String[] args) {
	
		System.out.println("isPrime2(16):"+isPower2Naive(16));
		System.out.println("isPrime2(12):"+isPower2BitMap(12));
	}
	
	private static boolean isPower2Naive(int n) {
		
		if(n==0) return false;
		while(n!=1) {
			if(n%2!=0)
				return false;
			n = n/2;
		}
		return true;
	}

	private static boolean isPower2BitMap(int n) {
		
		return (n!=0)&&((n&(n-1))==0);
		
	}
}
