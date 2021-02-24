package geeksforgeeks.bitmap;

public class OneOddOcurring {

	public static void main(String[] args) {	
	 //problem 1;	
	   int arr1 []= {4, 3, 4, 4, 4, 5, 5};
	   oneOddOccuring(arr1);
	   int arr2[]= {8,7,7,8,8};
	   oneOddOccuringWithXOR(arr2);
	   
	   //problem 2
	   int arr3[] ={1,3,4};
	   System.out.println("missing number in {1,3,4}:"+ findOddOccuranceSumMethod(arr3));
	   int arr4[] = {5,2,1,3};
	   System.out.println("missing number in  {5,2,1,3}}:"+ findOddOccuranceXORMethod(arr4));
		
	}
/*
 Problem 1:
 In the array repeatative numbers each occurs even times except one of them which occurs 
 odd time;
 find odd occuring numbers
 Input : {4, 3, 4, 4, 4, 5, 5}
 Output: 3
 Input : {8,7,7,8,8}
 Output : 8
 Each elements are positive integers
 */
	private static void  oneOddOccuring(int arr[]) {
		int n= arr.length;
		for(int i=0;i<n;i++) {
			int count = 0;
			
			for(int j=0;j<n;j++) {
				if(arr[i]==arr[j])
					count++;
			}
			if(count%2!=0)
				System.out.println(arr[i]);
		}
		//O(n^2)
	}
	
	private static void  oneOddOccuringWithXOR(int arr[]) {
		int n= arr.length;
		int res = 0;
		for(int i=0;i<n;i++) {
			res = res^arr[i];
		}
		System.out.println(res);
		
	}
	
	/*Problem 2:
	 Find the only odd occurring numbers as follows
	 Given an array of n number that has values in range of 1 to n+1;
	 Every number appears once
	 Hence One number is missing
	 Find the missing numbers
	 Input :{1,3,4}
	 Output:2
	 Input :{1,5,3,2}
	 Output:4
	 */
	private static int findOddOccuranceSumMethod(int arr[]) {
		 int n = arr.length;
		 int res = (n+1)*(n+2)/2;
		 for(int i=0;i<n;i++) {
			 res=res-arr[i];
		 }
		 return res;
	 }
	 
	private static  int findOddOccuranceXORMethod(int arr[]) {
		 int n = arr.length;
		 int res = 0;
		 for(int i=0;i<n;i++) {
			 res=res^arr[i];
		 }
		 
		 for(int i=1;i<=n+1;i++) {
			 res=res^i;
		 }
		 
		 return res;
	 }
}
