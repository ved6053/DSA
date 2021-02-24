package geeksforgeeks.recursion;

public class SubsetSum {
	public static void main(String[] args) {
		int arr1[] = {1,2,3};
		System.out.println("subset sum for {1,2,4} sum=4:"+subsetSum(arr1, 3, 4 ));
	}
	
	/*
	 Input {1,2,4} sum=4
	 Output 1
	 Input {10,20,15} sum =37
	 Output 0 
	 */
	
	private static int subsetSum(int arr[], int n, int sum) {
		if(n==0)
			return (sum==0)?1:0;
		return subsetSum(arr, n-1, sum)+subsetSum(arr, n-1, sum-arr[n-1]);
	}
}
