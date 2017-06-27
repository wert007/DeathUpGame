import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * @author qschuster
 *
 */
public class AStar {
	private Node[][] nodes;
	static AStar instance;
	final int NODEDISTANCE = 10;
	
	
	private Node currentNode;
	private PriorityQueue<Node> openlist = new PriorityQueue<Node>();
	private List<Node> closedlist = new ArrayList<Node>();
	
	/**
	 * Constructs AStar
	 * @param width Width of the map
	 * @param height Height of the map
	 * @param player Player node
	 */
	private AStar(int width, int height, Node player)
	{
		nodes = new Node[(int)width/10][(int)height/10];
		for(int i = 0; i < width; i = i+10){
			for(int j = 0; j < height; j = j+10){
				Position position = new Position(i,j);
				nodes[i][j] = new Node(position, 10);
			}
		}
	}
	
	
	/**
	 * Creates the AStar for the game
	 * @param width Width of the map
	 * @param height Height of the map
	 * @param player Player node
	 */
	public static void create(int width, int height, Node player)
	{
		instance = new AStar(width, height, player);
	}
	
	public void update(Player player){
		for(int i = 0; i < ; i = i+10){
			for(int j = 0; j < height; j = j+10){
				Position position = new Position(i,j);
				nodes[i][j] = new Node(position, 10);
			}
		}
	}
	
	/**
	 * Singleton
	 * @return Returns Instance
	 */
	public static AStar GetInstance()
	{
		return instance;
	}
	/**
	 * Gives the next Node on the path to end.
	 * 
	 * @param start Where I am standing
	 * @param end Where I want to be
	 * @return Node to go!
	 */
	public Node findPath(Node start, Node end){	
		openlist.add(start);
		while(!openlist.isEmpty()){
			currentNode = openlist.poll();
			if(currentNode == end){
				return currentNode.getNode();
			}
			closedlist.add(currentNode);
			expandNode(currentNode);
		}
		return null;
	}
	
	public void expandNode(Node currentNode){
		for(Node successor : currentNode.getSuccessor()){
			if(!closedlist.contains(successor)){
				 int tentative_g =  currentNode.getG() + 1;
				 if(openlist.contains(successor) && tentative_g <= successor.getG()){
					 successor.setG(tentative_g);
					 successor.setPredecessor(currentNode);
				 }
				 openlist.add(successor);
			}
		}
	}
	
	
}