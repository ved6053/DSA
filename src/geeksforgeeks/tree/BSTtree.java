package geeksforgeeks.tree;

public class BSTtree {
	
	public Node initialize() {
		
		Node root =insertItr(null, 20);
			root = insertItr(root, 15);
			root = insertItr(root, 30);
			root = insertItr(root, 12);
			root = insertItr(root, 7);
			root = insertItr(root, 18);
			root = insertItr(root, 40);
			root = insertItr(root, 35);
			root = insertItr(root, 50);
			root = insertItr(root, 80);
			return root;
		
	}
	
	
	
	boolean searchRec(Node root, int x) {
		if(root==null) 
			return  false;
		else if(root.key==x) 
			return true;
		else if(root.key>x)
			return searchRec(root.left,x);
		else 
			return searchRec(root.right,x);
	}
	
	boolean searchItr(Node root, int x) {
		while(root!=null) {
		 if(root.key==x)
			 return true;
		 else if(root.key>x)
			 root=root.left;
		 else
			 root=root.right;
		}
		return false;
	}
	
	Node insertRec(Node root, int x) {
		if(root==null)
			return new Node(x);
		else if(root.key>x)
			root.left = insertRec(root.left,x);
		else if(root.key<x)
			root.right = insertRec(root.right,x);
		
		return root;
		// Time Complexity O(1) Auxiliary Space O(h)
	}
	
	Node insertItr(Node root, int x) {
		Node temp = new Node(x);
		Node parent = null, curr=root;
		while(curr!=null) {
			parent = curr;
			if(curr.key>x)
				 curr = curr.left;
			else if(curr.key<x)
				curr = curr.right;
			else
				return root;
		}
		
		if(parent==null)
			return temp;
		if(parent.key>x)
			parent.left = temp;
		else
			parent.right = temp;
		return root;
		// Time Complexity O(1) Auxiliary Space O(1)
	}
	
	
	Node getDelSucc(Node root) {
		Node curr = root.right;
		
		while(curr!=null&&curr.left!=null)
			curr=curr.left;
		return curr;
	}
	
	Node delNode(Node root, int x) {
		if(root==null) return null;
		if(root.key>x) {
			root.left = delNode(root.left,x);
		} else if(root.key<x) {
			root.right= delNode(root.right,x);
		}else {
			  if(root.left==null)
				  return root.right;
			  else if(root.right==null)
				  return root.left;
			  else {
				  Node succ = getDelSucc(root);
				  root.key = succ.key;
				  root.right = delNode(root.left, succ.key);
			  }
		}
		return root;
	}
	
	int floor(Node root, int x) {
		int floorVal=0;
		while(root!=null) {
			if(root.key==x)
				return root.key;
			else if(root.key<x) {
				floorVal=root.key;
				root = root.right;
			} else
				root = root.left;
		}
		return floorVal;
	}
	
	int ceil(Node root, int x) {
		int ceilVal=0;
		while(root!=null) {
			if(root.key==x)
				return root.key;
			else if(root.key>x) {
				ceilVal = root.key;
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return ceilVal;
	}
	public static void main(String[] args) {
		BSTtree t= new BSTtree();
		Node root=t.initialize();
		root = t.delNode(root, 7);
		System.out.println("Recursive Search k=7:"+t.searchRec(root, 7));
		root = t.insertRec(root, 7);
		System.out.println("Iterative Search k=7:"+t.searchRec(root, 7));
		System.out.println("Floor Value of 37:"+t.floor(root, 37));
		System.out.println("Ciel Value of 37:"+t.ceil(root, 37));
	}

}
