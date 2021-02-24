package geeksforgeeks.maths;

public class GCD {
	
	public static void main(String[] args) {
		
		System.out.println("gcd(4,6):"+gcdNaive(4,6));
		
		System.out.println("gcd(12,21):"+gcdEcludian(12,21));
		
		System.out.println("gcd(15,25):"+gcdEcludOptimize(15,25));
		
	}
	
	public static int gcdNaive(int a, int b) {
		int res = Math.min(a, b);
		while(res>0) {
			if(a%res==0 && b%res==0)
				break;
			res--;
		}
		return res;//O(min(a,b))
	}
	
	public static int gcdEcludian(int a, int b) {
		while(a!=b) {
			if(a>b)
				a = a-b;
			else
				b = b-a; 
		}
		return a;//O(log(min(a,b)))
	}
	
	public static int gcdEcludOptimize(int a, int b) {
		if(b==0)
			return a;
		else 
			return gcdEcludOptimize(b, a%b);
		
	}
}
