package geeksforgeeks.bitmap;

public class FindTwoOddAprearing {
	public static void main(String[] args) {
		
		int arr1[] = {3,4,3,4,5,4,4,6,7,7};
		oddAppearing(arr1);
		int arr2[] = {20,15,20,16};
		oddAppearing(arr2);
	}
	/*
	 Find two odd appearing numbers
	 INPUT:{3,4,3,4,5,4,4,6,7,7}
	 OUTPUT:5,6
	 INPUT:{20,15,20,16}
	 OUTPUT:15,16
	 */
	private static void oddAppearing(int arr[]) {
		int n = arr.length;
		int XOR = 0, res1 =0, res2=0;
		for(int i=0;i<n;i++) {
			XOR =XOR^arr[i];
		}
		int sn = XOR&~(XOR-1);//right most set bit;
	    for(int i=0;i<n;i++) {
	    	if((arr[i]&sn)!=0)
	    		res1 = res1^arr[i];
	    	else 
	    		res2= res2^arr[i];
	    }			
	    
	    System.out.println("("+res1+", "+res2+")");
	}
}
