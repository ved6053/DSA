package geeksforgeeks;

public class CountDigits {

	public static void main(String[] args) {
		
		System.out.println("Digit count in  12345 :"+countDigitItr(12345));
		
		System.out.println("Digit count in  745 :"+countDigitRec(745));
		
		System.out.println("Digit count in  4567 :"+countDigitRec(4567));
	
	}
	
	public static int countDigitItr(long n) {
		
		int count = 0;
		while(n>0) {
			n = n/10;
			++count;
		}
		return count;
	}
	
	public static int countDigitRec(long n) {
		if(n==0)
			return 0;
		return 1+countDigitRec(n/10);
	}
	
	public static int countDigitLgm(long n) {
		return (int) Math.floor(Math.log10(n)+1);
	}
 }
