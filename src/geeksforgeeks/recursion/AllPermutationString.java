package geeksforgeeks.recursion;

public class AllPermutationString {
	public static void main(String[] args) {
		permute(new StringBuilder("ABC"),0);
	}
	
	/*
	 INPUT : ABC
	 OUTPUT : ABC ACB BAC BCA CAB CBA
	 INPUT : AB
	 OUTPUT : AB BA
	 */
	
	private static void swap(StringBuilder s, int i, int  j) {
		Character t = s.charAt(i);
		s.setCharAt(i,s.charAt(j));
		s.setCharAt(j, t);
	}
	private static void permute(StringBuilder s, int i) {
		if(i==s.length()-1) {
			System.out.println(s);
			return;
		}
		
		for(int j=i;j<s.length();j++) {
			swap(s, i,j);
			permute(s, i+1);
			swap(s,j,i);
			
		}
	}
}
