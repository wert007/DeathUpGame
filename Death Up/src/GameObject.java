import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;


public abstract class GameObject {
	
	private CollisionBox collisionBox;
	private Image texture;
	
	
	/**
	 * updates the gameObject
	 * @param delta Time in milliseconds since last update
	 */
	public void update(int delta){
		
	}
	
	/**
	 * renders the gameObject
	 * @param graphic g to render
	 */
	public void render(Graphics g){
		
	}
	
}

