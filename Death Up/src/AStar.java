import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

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
	private Random rdm;
	
	/**
	 * Constructs AStar
	 * @param width Width of the map
	 * @param height Height of the map
	 * @param player Player node
	 */
	private AStar(int width, int height, Node player)
	{
		currentNode = null;
		rdm = new Random();
		nodes = new Node[(int)width/10 + 1][(int)height/10 + 1];
		for(int i = 0; i < width; i = i+10){
			for(int j = 0; j < height; j = j+10){
				Position position = new Position(i,j);
				nodes[i/10][j/10] = new Node(position, 10);
			}
		}
		for (int x = 0; x < nodes.length; x++) {
			for (int y = 0; y < nodes[x].length; y++) {
				if(nodes[x][y] != null) //TODO ERROR
				nodes[x][y].setSuccessor(successors(x,y));
			}
		}
	}
		
	public Node[] successors(int x, int y)
	{
		int size = 0;
		
		for (int i = -1; i < 1; i++) {
			for (int j = -1; j < 1; j++) {
				
				if(x+i> -1 && y+j > -1){
					size++;
				}
			}	
		}
		
		Node[] result = new Node[size];
		for (int i = -1; i < 1; i++) {
			for (int j = -1; j < 1; j++) {
				
				if(x+i> -1 && y+j > -1){
					size--;
					result[size] = nodes[x+i][y+j];
				}
			}	
		}
	return result;	
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
		for(int i = 0; i < nodes.length; i++){
			for(int j = 0; j < nodes[1].length; i++){
				int a = Math.abs(player.getPosition().getXInt() - nodes[i][j].getPosition().getXInt());
				int b = Math.abs(player.getPosition().getYInt() - nodes[i][j].getPosition().getYInt());
				double c = Math.pow(a,2) + Math.pow(b, 2);
				int h = (int)Math.sqrt(c);
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
	
	public Node getRdmSpawn()
	{
		int x =rdm.nextInt(nodes.length - 1);
		int y = rdm.nextInt(nodes[0].length - 1);
		boolean xIsBorder = rdm.nextBoolean();
		if(xIsBorder)
			x = 0;
		else
			y = 0;
		return nodes[x][y];
	}
	
	
	public Node findPath(Node start, Node end){
		openlist.add(start);
		while(!openlist.isEmpty()){
			currentNode = openlist.poll();
			if(currentNode == end){
				return currentNode.getNextNode(start);
			}
			closedlist.add(currentNode);
			expandNode(currentNode, start);
		}
		return null;
	}
	
	public void expandNode(Node currentNode, Node enemy){
		for(Node successor : currentNode.getSuccessor()){
			
			if(!closedlist.contains(successor)){
				//TODO ERROR
				int a = Math.abs(currentNode.getPosition().getXInt() - successor.getPosition().getXInt());
				int b = Math.abs(currentNode.getPosition().getYInt() - successor.getPosition().getYInt());
				int g = (int)Math.sqrt(Math.pow(a,2) + Math.pow(b, 2));
				//TODO ERROR
				 int tentative_g =  g + 10;
				 
				 if(openlist.contains(successor) && tentative_g <= successor.getG()){
					 successor.setG(tentative_g);
					 successor.setPredecessor(currentNode);
				 }
				 openlist.add(successor);
			}
				 
			}
		}
	}
	