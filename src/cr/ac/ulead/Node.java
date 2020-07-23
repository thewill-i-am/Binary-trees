package cr.ac.ulead;

public class Node {

	public int data; 
	public Node leftChild; 
	public Node rightChild; 

	public void displayNode() 
	{
		System.out.print('{');
		System.out.print(data);
		System.out.print("} ");
	}

}
