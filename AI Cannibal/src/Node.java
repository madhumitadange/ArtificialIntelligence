public class Node {
	private int M,C,B;
	private Node parent;
	 	 
	 public Node(int m, int c, int b,  Node parent)
	 {
	  this.M = m;
	  this.C = c;
	  this.B = b;
	  this.parent = parent;
	  
	 }
	 
	 public Node()
	 {
		 this.M =3 ;
		  this.C = 3;
		  this.B = 1;
	   
	 }
	  
	 public int getMiss() 
	 {
	  return M;
	 }
	 
	 public void setMiss(int m) 
	 {
	  this.M = m;
	 }
	 
	 public int getCanni() 
	 {
	  return C;
	 }
	 
	 public void setCanni(int c) 
	 {
	  this.C = c;
	 }
	 
	 public int getBoat() 
	 {
	  return B;
	 }
	 
	 public void setBoat(int b) 
	 {
	  this.B = b;
	 }
	 
	 public Node getParent() 
	 {
	  return parent;
	 }
	 
	 public void setParent(Node parent) 
	 {
	  this.parent = parent;
	 }
	 
		
}