package geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestTree {
	
	
	
	Node intialize() {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(35);
		root.right.left= new Node(50);
		return root;
	}
	
	void inorderRec(Node root) {
		
		if(root!=null) {
			inorderRec(root.left);
			System.out.print(root.key+" ");
			inorderRec(root.right);
		}//Time complexity O(n) & Auxiliary Space O(h) , h is height of tree
	}
	
	void iterativeInorder(Node root) {
		Stack<Node> st= new Stack<>();
		Node curr= root;
		while(curr!=null||st.isEmpty()==false) {
			while(curr!=null) {
				st.push(curr);
				curr= curr.left;
			}
			
			curr = st.pop();
			System.out.print(curr.key+" ");
			curr=curr.right;
		}
	}
	void preorderRec(Node root) {
		
		if(root!=null) {
			System.out.print(root.key+" ");
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}
	
	void iterativePreorder(Node root) {
		if(root==null) return;
		Stack<Node> st= new Stack<>();
		st.push(root);
		while(st.isEmpty()==false) {
			Node curr= st.pop();
			System.out.print(curr.key+" " );
			
			if(curr.right!=null) st.push(curr.right);
			if(curr.left!=null) st.push(curr.left);
		}
		
		//Time Complexity O(n) Auxiliary O(n)
	}
	
	void iterativePreorderOptimize(Node root) {
		if(root==null) return;
		Stack<Node> st = new Stack<>();
		Node curr=root;
		while(curr!=null||st.isEmpty()==false) {
			while(curr!=null) {
				System.out.print(curr.key+" ");
				if(curr.right!=null)
					st.push(curr.right);
				curr= curr.left;
			  }
			
			if(st.isEmpty()==false) {
				curr=st.pop();
			}
		}
		
		//Time complexity O(n) Auxiliary Space O(h)
	}

	void postorderRec(Node root) {
		
		if(root!=null) {
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.print(root.key+" ");
		}
	}
	
	void levelOrder(Node root) {
		if(root==null) return;
		Queue<Node> q= new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node curr=q.poll();
			System.out.print(curr.key+"  ");
			if(curr.left!=null)
				q.add(curr.left);
			if(curr.right!=null)
				q.add(curr.right);
		}
	}
	
	int height(Node root) {
		if(root==null)
			return 0;
		else 
			return 1+Math.max(height(root.left), height(root.right));
		//Time complexity O(n) , Auxiliary Space O(h)
	}
	
	int getSize(Node root) {
		if(root==null) 
			return 0;
		else 
			return 1+getSize(root.left)+getSize(root.right);
	}
	
	int getMax(Node root) {
		if(root==null)
			return Integer.MIN_VALUE;
		else
			return Math.max(root.key, Math.max(getMax(root.left), getMax(root.right)));
	}
	
	void printNodeAtK(Node root, int k) {
		if(root==null) return;
		if(k==0) 
			System.out.print(root.key+" ");
		else {
			printNodeAtK(root.left, k-1);
			printNodeAtK(root.right, k-1);
		}
	}
	
	public static void main(String[] args) {
		TestTree t = new TestTree();
		Node root = t.intialize();
		System.out.println("Inoder traversal By Recurrion>>>>>>>");
		t.inorderRec(root);
		System.out.println();
		System.out.println("Inoder traversal By iteration>>>>>>>");
		t.iterativeInorder(root);
		System.out.println();
		
		System.out.println("Preorder traversal Rec  >>>>>>>");
		t.preorderRec(root);
		System.out.println();
		System.out.println("Preorder traversal Iterative >>>>>>>");
		t.iterativePreorder(root);
		System.out.println();
		System.out.println("Preorder traversal Iterative Optomize>>>>>>>");
		t.iterativePreorderOptimize(root);
		System.out.println();
		System.out.println("Postorder traversal>>>>>>>");
		t.postorderRec(root);
		System.out.println();
		System.out.println("Levelorder traversal>>>>>>>");
		t.levelOrder(root);
		System.out.println();
		System.out.println("Height Of Tree>>>>>>>");
		System.out.println(t.height(root));
		System.out.println("Size Of Tree>>>>>>>");
		System.out.println(t.getSize(root));
		System.out.println("Max Of Tree>>>>>>>");
		System.out.println(t.getMax(root));
		System.out.println("Print Node at Level k , k=1 >>>>>>>>>>>");
		t.printNodeAtK(root, 1);
		
		
	}

}
