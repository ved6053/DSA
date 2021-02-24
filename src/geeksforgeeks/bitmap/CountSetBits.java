package geeksforgeeks.bitmap;

public class CountSetBits {
	
	public static void main(String[] args) {
		System.out.println("countBitsSet(13):"+countBitsSetNaive(13));
		System.out.println("countBitsSet(15):"+countBitsSetBrainKerningam(15));
		initailize();
		System.out.println("countBitsSet(215):"+countBitSetLookup(215));
		
		System.out.println("countBitsSet(150):"+countBitSetLookup(150));
		
	}
	
	private static int countBitsSetNaive(int n) {
		int res = 0;
		
		while(n>0) {
			res +=n&1;
			n=n>>1;
		}
		
		return res;
	}
	
	private static int countBitsSetBrainKerningam(int n) {
		
		int res = 0;
		while(n>0) {
			n = n&(n-1);
			res++;
		}
		
		return res;
	}
	
	//Lookup table method
	
	private static int table[] = new int[256];
	private static void initailize() {
		table[0] = 0;
		for(int i=1;i<256;i++)
			table[i] = (i&1)+table[i/2];
	}
	
	private static int countBitSetLookup(int n) {
		int res = table[n&0xff];
		n=n>>8;
		res = res+table[n&0xff];
		n=n>>8;
		res = res+table[n&0xff];
		n=n>>8;
		res = res+table[n&0xff];
		return res;
	}
}
