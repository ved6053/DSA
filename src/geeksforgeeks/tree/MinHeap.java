package geeksforgeeks.tree;

public class MinHeap {
	int []arr;
	int size;
	int capacity;
	
	public MinHeap(int c) {
		arr = new int[c];
		size = 0;
		capacity = c;
	}
	
	public void intialize() {
		size= 8;
		arr = new int[] {10,15,25,50,100,20,40,45,0,0};
		buildHeap();
	}
	
	
	
	int left(int i) {
		return 2*i+1;
	}
	
	int right(int i) {
		return 2*i+2;
	}
	
	int parent(int i) {
		return (i-1)/2;
	}
	
	
	void insert(int x) {
		if(size==capacity) {
			System.out.println("Heap is full ");
			return;
		}
		size++;
		arr[size-1] =x;
		for(int i=size-1;i!=0 && arr[parent(i)]>arr[i];i++) {
			int temp = arr[i];
			arr[i]= arr[parent(i)];
			arr[parent(i)]= temp;
			i = parent(i);
		}
	}
	
	void heapify(int i) {
		int lt = left(i), rt = right(i);
		int smallest = i;
		if(lt<size && arr[lt]<arr[i])
			smallest = lt;
		if(rt<size && arr[rt]<arr[i])
			smallest = rt;
		if(smallest!=i) {
			int temp =arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			heapify(smallest);
		}
		// Time complexity O(log(size)) and Auxiliary Space O(log(n)
	}
	
	int extract() {
		if(size==0)
			
			return Integer.MAX_VALUE;
		
		int res = arr[0];
		
		if(size==1) {
			size--;
		}else {
			int temp = arr[0];
			arr[0] = arr[size-1];
			temp = arr[0];
			size--;
			heapify(0);
		}
		
		return res;
	}
	
	void decreaseKey(int i, int x) {
		arr[i] = x;
		while(i!=0 && arr[parent(i)]>arr[i]) {
			int temp = arr[i];
			arr[i] = arr[parent(i)];
			arr[parent(i)] = temp;
			i = parent(i);
		}
	}
	void deleteKey(int x) {
		decreaseKey(x, Integer.MIN_VALUE);
		extract();
	}
	
	void buildHeap() {
		for(int i=(size-1)/2;i>=0;i--)
			heapify(i);
		
		//Time complexity O(n)
	}
	
	public static void main(String args[]) {
			MinHeap h= new MinHeap(10);
			h.intialize();
			System.out.println("Heap before extract");
			
			for(int k:h.arr)
				System.out.print(k+" ");
			System.out.println();
			System.out.println("Extract from heap "+h.extract());
			System.out.println("Heap After extract");
			
			for(int k:h.arr)
				System.out.print(k+" ");

			System.out.println();
			System.out.println("Delete key at index 5");
			h.deleteKey(5);
			for(int k:h.arr)
				System.out.print(k+" ");
			
			System.out.println();
	}
	
	

}
