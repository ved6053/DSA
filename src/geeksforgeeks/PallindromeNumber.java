package geeksforgeeks;

public class PallindromeNumber {

	public static void main(String[] args) {
			System.out.println("isPallindrome(456):"+isPallindromeOwn(456));
	}
	
	public static boolean isPallindromeOwn(long num) {
		long temp = num;
		long rev = 0;
		while(temp>0) {
			rev = rev*10+temp%10;
			temp = temp/10;
			
		}
		
		return num==rev;
	}

}
