import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * 
 * @author qschuster
 *
 */
public class CollisionBox {

	private Rectangle rectangle;
	private GameObject parent;
	private static ArrayList<CollisionBox> allCollisionBoxes;
	private Position pos;
	
	/**
	 * Create a new CollisionBox
	 * @param x x-Position
	 * @param y y-Position
	 * @param width Width of the CollisionBox
	 * @param height Height of the CollisionBox
	 * @param parent The Parent of the CollisionBox
	 */
	public CollisionBox(int x, int y, int width, int height, GameObject parent)
	{
		rectangle = new Rectangle(x, y, width, height);
		this.parent = parent;
		pos = new Position(x, y);
		if(allCollisionBoxes == null){
			allCollisionBoxes = new ArrayList<CollisionBox>();
		}
		allCollisionBoxes.add(this);
	}
	
	/**
	 * Create a new CollisionBox
	 * @param pos Position
	 * @param size Size
	 * @param parent The Parent of the CollisionBox
	 */
	public CollisionBox(Position pos, Position size, GameObject parent)
	{
		rectangle = new Rectangle(pos.getX(), pos.getY(), size.getX(), size.getY());
		this.parent = parent;
		this.pos = pos;
		
		if(allCollisionBoxes == null){
			allCollisionBoxes = new ArrayList<CollisionBox>();
		}
		allCollisionBoxes.add(this);
	}
	
	
	/**
	 * Create a new CollisionBox
	 * @param rectangle Collision Area
	 * @param parent The Parent of the CollisionBox 
	 */
	public CollisionBox(Rectangle rectangle, GameObject parent)
	{
		this.rectangle = rectangle;
		this.parent = parent;
		pos = new Position(rectangle.x, rectangle.y);
		
		if(allCollisionBoxes == null){
			allCollisionBoxes = new ArrayList<CollisionBox>();
		}
		allCollisionBoxes.add(this);
	}
	
	/**
	 * Updates the Position
	 * @param pos New Position
	 */
	public void update(Position pos)
	{
		this.rectangle.setLocation(pos.getX(), pos.getY());
		this.pos.setX(pos.getX());
		this.pos.setY(pos.getY());
	}
	
	/**
	 * Updates the Position
	 * @param x new x-Position
	 * @param y new y-Position
	 */
	public void update(int x, int y)
	{
		this.rectangle.setLocation(x,y);
		this.pos.setX(x);
		this.pos.setY(y);
	}
	
	/**
	 * Collides with CollisionBox other?
	 * 
	 * @param other The other CollisionBox
	 * @return Collides with CollisionBox other?
	 */
	public boolean collide(CollisionBox other){
		return this.rectangle.intersects(other.getRectangle());
	}
	
	
	/**
	 * Returns all the CollisonBoxes it collides with.
	 * 
	 * @return all the CollisionBoxes it collides with;
	 */
	public CollisionBox[] collideWith(){
		ArrayList<CollisionBox> collide = new ArrayList<CollisionBox>();
		
		for(int i =0; i < allCollisionBoxes.size(); i++){
			if(collide(allCollisionBoxes.get(i))){
				collide.add(allCollisionBoxes.get(i));
			}
		}
		return (CollisionBox[])collide.toArray();
	}
	
	public Rectangle getRectangle(){
		return this.rectangle;	
	}
	
	public GameObject getParent(){
		return this.parent;	
	}
	
	public Position getPosition(){
		return pos;
	}
	
	public void setRectangle(Rectangle rectangle){
		this.rectangle = rectangle;	
	}
	
	public void setParent(GameObject parent){
		this.parent = parent;
	}
	
}

