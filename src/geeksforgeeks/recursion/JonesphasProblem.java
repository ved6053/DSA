package geeksforgeeks.recursion;

public class JonesphasProblem {
	public static void main(String[] args) {
		System.out.println("Jonespas surival(7,3):"+josModified(7,3));
	}
	
	private static int jos(int n, int k) {
		if(n==0)
			return 0;
		return (jos(n-1,k)+k)%n;
	}
	
	private  static int josModified(int n, int k) {
		return jos(n,k)+1;
	}
}
