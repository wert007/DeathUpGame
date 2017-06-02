import java.awt.Rectangle;
import java.util.ArrayList;


public class CollisionBox {

	private Rectangle rectangle;
	private GameObject parent;
	private ArrayList<CollisionBox> allCollisionBoxes;
	
	/**
	 * testet ob es eine bestimmten Box ber�hrt
	 * 
	 * @param other die box mit der es sich berr�hren soll
	 * @return ob es sich mit dieser CollisionBox berr�hrt
	 */
	public boolean collide(CollisionBox other){
		return false;
	}
	
	
	/**
	 * Testet mit welcher Box es sich berr�hrt
	 * 
	 * @return mit welcher CollisionBox es sich berr�hrt
	 */
	public CollisionBox[] collideWith(){
		
	}
	}
}
