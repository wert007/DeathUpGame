/**
 * 
 * @author phamacher (actually not)
 *
 */
public class Node implements Comparable{
	private Position position;
	private int walkSpeed;
	private Node  predecessor;
	private Node[] successor;
	private int g;
	
	/**
	 * Creates a new Node
	 * @param pos Position of the Node
	 * @param walkSpeed Walkspeed of the Node
	 */
	public Node(Position pos, int walkSpeed)
	{
		this.position = pos;
		this.walkSpeed = walkSpeed;
		//successor hinzufügen
	}
	
	public Position getPosition()
	{
		return position;
	}
	
	public int getWalkSpeed()
	{
		return walkSpeed;
	}
	
	public void setPredecessor(Node predecessor)
	{
		this.predecessor = predecessor;
	}

	public Node getPredecessor()
	{
		return this.predecessor;
	}
	
	public Node[] getSuccessor()
	{
		return this.successor;
	}
	
	public int getG()
	{
		return this.g;
	}
	
	public void setG(int g)
	{	
		this.g = g;
	}

	@Override
	public int compareTo(Object o) {
		if(this.walkSpeed > ((Node)o).getWalkSpeed()){
			return 1;
		}
		else if(this.walkSpeed <((Node)o).getWalkSpeed()){
			return -1;
		}
		else{
			return 0;
		}
	}
	
	
}
