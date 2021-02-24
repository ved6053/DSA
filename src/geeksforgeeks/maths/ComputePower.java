package geeksforgeeks.maths;

public class ComputePower {

	public static void main(String[] args) {

		System.out.println("Pow(3,5):"+powNaive(3,5));
		System.out.println("Pow(7,3):"+powRec(7,3));
		System.out.println("Pow(2,10):"+powItrBitwise(2,10));
	}

	private static int powNaive(int x, int n) {
		int res = 1;
		
		for(int i=1;i<=n;i++)
			 res*=x;
		
		return res;//O(n)
	}
	
	private static int powRec(int x, int n) {
		
		if(n==0)
			return 1;
		int temp = powRec(x, n/2);
		temp =temp*temp;
		if(n%2==0)
			return temp;
		else
			return temp*x;
		
	}
	
	private static int powItrBitwise(int x, int n) {
		int res =1;
		while(n>0) {
			if((n&1)==1)
				res=res*x;
			x =x*x;
			n=n>>1;
		}
		return res;
	}
	
}
