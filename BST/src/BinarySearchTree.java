import java.util.*;

public class BinarySearchTree 
{
	// Inner node class
	public class Node 
	{
		private int data;
		private Node left;
		private Node right;

		// Constructor
		public Node(int data, Node left, Node right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	private Node root;
	
	// Constructor of Tree
	public BinarySearchTree()
	{
		root = null;
	}
	
	// Call Insert
	public boolean insert(int data)
	{
		return insert(root, data);
	}
	
	// Recursive Insert
	// Does not allow duplicates
	private boolean insert(Node p, int data)
	{
		Node temp = p;
		
		if(root == null)
			root = new Node(data, null, null);
		else if(data < temp.data)
		{
			if(temp.left == null)
				temp.left = new Node(data, null, null);
			else
				return insert(temp.left, data);
		}
		else if(data > temp.data)
		{
			if(temp.right == null)
				temp.right = new Node(data, null, null);
			else
				return insert(temp.right, data);
		}
		else if(data == temp.data)
			return false;
			
		
		return true;
	}
	
	// Call Search
	public boolean search(int data) 
	{
		return search(data, root);
	}
	
	// Recursive Search
	private boolean search(int data, Node p) 
	{
		Node temp = p;
		if(temp == null)
			return false;
		else if(temp.data == data)
			return true;
		else
		{
			if(data < temp.data)
				return search(data, p.left);
			else
				return search(data, p.right);
		}
	}
	
	// Call Delete
	public boolean delete(int data) 
	{
		return delete(data, root);
	}
	
	// Iterative Delete
	private boolean delete(int data, Node p) 
	{
		Node temp = p;
		Node prev = null;
		
		while(temp != null)
		{
			if(data == temp.data)
				break;
			else if(data < temp.data)
			{
				prev = temp;
				temp = temp.left;
			}
			else
			{
				prev = temp;
				temp = temp.right;
			}
		}
		
		if(temp == null)
			return false;
		else
		{
			if(temp.left == null)
			{
				if(temp == root)
					root = temp.right;
				else if(temp == prev.left)
					prev.left = temp.right;
				else
					prev.right = temp.right;
			}
			else if(temp.right == null)
			{
				if(temp == root)
					root = temp.left;
				else if(temp == prev.left)
					prev.left = temp.left;
				else
					prev.right = temp.left;
			}
			else
			{
				Node L = temp.left;
				Node R = temp;
				
				while(L.right != null)
				{
					R = L;
					L = L.right;
				}
				
				temp.data = L.data;
				if(R == temp)
					R.left = L.left;
				else
					R.right = L.left;
			}
		}
		
		return true;
	}
	
	// Random number generator
	public boolean randgen(int num, int seed) 
	{
		Random random = new Random();
		int enter;
		
		for(int i = 0; i < num; i++)
		{
			enter = random.nextInt(10000/seed);
			insert(enter);
		}
		return true;
	}
	
	// Call InOrder
	public void inOrder() 
	{
		inOrder(root);
	}
	
	// Recursive InOrder function
	private void inOrder(Node node)
	{
		if(node == null)
			;
		else 
		{
			inOrder(node.left);
			System.out.print(" " + node.data + " ");
			inOrder(node.right);
		}
	}
}
