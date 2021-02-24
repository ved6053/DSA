package geeksforgeeks.maths;

import java.util.Arrays;
import java.util.Vector;

public class SieveOfEratorthenes {

	public static void main(String[] args) {
		System.out.println("Sieve of 10");
		seiveNaive(10);
		System.out.println("Sieve of 23");
		seiveOptimizeOne(23);
		System.out.println("Sieve of 1024");
		seiveOptimizeTwo(1024);
	}
	
	public static boolean isPrime(int n) {
		if(n==1) return false;
		
		if(n==2 || n==3) return true;
		
		if(n%2 == 0 || n%3 == 0) return false;
		
		for(int i=5; i*i<n; i+=6) {
			if(n%i==0||n%(i+2)==0)
				return false;
		}
		
		return true;
	}
	
	public static void seiveNaive(int n) {	
		for(int i=2;i<=n;i++)
			if(isPrime(i))
				System.out.println(i);
	}
	
	public static void seiveOptimizeOne(int n) {
		boolean isPrime[] = new boolean[n+1];
		Arrays.fill(isPrime, true);
		for(int i=2;i*i<n;i++) {
			if(isPrime[i]) {
				for(int j=i*i;j<=n;j=j+i)
					isPrime[j]=false;
			}
		}
		
		for(int i=2;i<=n;i++) {
			if(isPrime[i]) {
				System.out.println(i);
			}
		}
	}
	
	public static void seiveOptimizeTwo(int n) {
		boolean isPrime[] = new boolean[n+1];
		Arrays.fill(isPrime, true);
		for(int i=2;i<=n;i++) {
			if(isPrime[i]) {
				System.out.println(i);
				for(int j=i*i;j<=n;j=j+i)
					isPrime[j]=false;
			}
		}
	}
	

}
