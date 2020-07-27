package cr.ac.ulead;

import cr.ac.ulead.modelos.Persona;

public class Node {

	public Persona data;
	public Node leftChild; 
	public Node rightChild; 

	public void displayNode() 
	{
		System.out.print('{');
		System.out.print(data);
		System.out.print("} ");
	}

}
