import java.awt.Rectangle;
import java.util.ArrayList;


public class CollisionBox {

	private Rectangle rectangle;
	private GameObject parent;
	private ArrayList<CollisionBox> allCollisionBoxes;
	
	/**
	 * testet ob es eine bestimmten Box berührt
	 * 
	 * @param other die box mit der es sich berrühren soll
	 * @return ob es sich mit dieser CollisionBox berrührt
	 */
	public boolean collide(CollisionBox other){
		return false;
	}
	
	
	/**
	 * Testet mit welcher Box es sich berrührt
	 * 
	 * @return mit welcher CollisionBox es sich berrührt
	 */
	public CollisionBox[] collideWith(){
		
	}
	}
}
