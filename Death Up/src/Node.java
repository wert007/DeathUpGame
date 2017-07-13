/**
 * 
 * @author qschuster
 *
 */

public class Node implements Comparable{
	private Position position;
	private Node  predecessor;
	private Node[] successor;
	private int walkspeed;
	private int g;
	private int h;
	
	/**
	 * Creates a new Node
	 * @param pos Position of the Node
	 * @param walkSpeed Walkspeed of the Node
	 */
	public Node(Position pos, int walkSpeed)
	{
		this.position = pos;
		this.h = walkSpeed;
		//successor hinzufügen
	}
	
	public Position getPosition()
	{
		return position;
	}
	
	public int getH()
	{
		return h;
	}
	
	public void setH(int h)
	{
		this.h = h;
	}
	
	public void update(Player player){
		this.h = this.position.distance(player.getPosition())/10;
	}
	
	public void setPredecessor(Node predecessor)
	{
		this.predecessor = predecessor;
	}
	
	public void setSuccessor(Node[] successor)
	{
		this.successor = successor;
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
	
	public Node getNode(){
		if(this.predecessor.getG() != 0){
			return this.predecessor.getNode();
		}
		else{
			return this;
		}
	}
	
	public Node getNextNode(Node start){
		if(this.predecessor == start){
			return this;
		}
		else{
			return this.predecessor.getNextNode(start);
		}
	}

	@Override
	public int compareTo(Object o) {
		if(this.h > ((Node)o).getH()){
			return 1;
		}
		else if(this.h <((Node)o).getH()){
			return -1;
		}
		else{
			return 0;
		}
	}
	
	
}
