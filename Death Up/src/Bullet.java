import org.newdawn.slick.Image;


public class Bullet extends GameObject {

	private Image texture;
	private CollisionBox collisionBox;
	private float direction;
	private Position position;
	
	/**
	 * testet ob die Bullet etwas trifft
	 * 
	 * @return ob es etwas getroffen hat oder nicht
	 */
	public boolean update(){
		return true;
	}
	}
