package geeksforgeeks;

public class LCM {

	public static void main(String[] args) {
		System.out.println("LCM(4,6):"+lcmNaive(4,6));
		System.out.println("LCM(9,12):"+lcmNaive(9,12));
	}

	public static int lcmNaive(int a, int b) {
		int res = Math.max(a, b);
		
		while(true) {
			if(res%a==0 && res%b==0)
				return res;
			res++;
		}
		//O(a*b-max(a*b))
	}
	
	public static int gcd(int a, int b) {
		if(b==0)
			return a;
		else
			return gcd(b, a%b);		
	}
	
	public static int lcmOptimize(int a, int b) {
		return (a*b)/gcd(a,b);//O(log(min(a,b)));
	}
}
