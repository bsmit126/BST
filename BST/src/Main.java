/* 
 *  Binary Search Tree
 *
 * insert(data)
 * delete(data)
 * search(data)
 * randGen(num, seed)
 * inOrder()
 */

import java.util.*;

public class Main 
{
	public static void main(String [] args) 
	{
		BinarySearchTree bst = new BinarySearchTree();
		Scanner in = new Scanner(System.in);
		
		int digit, num, seed, select;
		
		System.out.println("Enter amount of digits to insert into the tree: ");
		digit = in.nextInt();
		System.out.println("Enter numbers, or enter 0 for random numbers: ");
		
		for(int i = 0; i < digit; i++)
		{
			num = in.nextInt();
			if(num == 0)
			{
				System.out.println("Enter seed value: ");
				seed = in.nextInt();
				bst.randgen(digit, seed);
				break;
			}
			else
				bst.insert(num);
		}
		
		int value;
		select = 0;
		
		while(select != 5)
		{
			
			System.out.println();
			display();
			System.out.println();
			select = in.nextInt();
			
			switch(select)
			{
			case 1:
				System.out.println("\nEnter value to search: ");
				value = in.nextInt();
				if(bst.search(value))
					System.out.println("\nValue is in the tree.\n");
				else
					System.out.println("\nValue is not in the tree.\n");
				break;
			case 2:
				System.out.println("Enter value to insert: ");
				value = in.nextInt();
				bst.insert(value);
				break;
			case 3:
				System.out.println("Enter value to delete: ");
				value = in.nextInt();
				if(bst.delete(value))
					System.out.println("\nValue was deleted.\n");
				else
					System.out.println("\nValue was not deleted.\n");
				break;
			case 4:
				System.out.println();
				bst.inOrder();
				System.out.println();
				break;
			}
		}
		
		System.out.println("\nProgram has ended.");
	}
	
	public static void display() 
	{
		System.out.println(" *********************** ");
		System.out.println("1 - Search");
		System.out.println("2 - Insert");
		System.out.println("3 - Delete");
		System.out.println("4 - Print");
		System.out.println("5 - Exit");
		System.out.println(" *********************** ");
	}
}
