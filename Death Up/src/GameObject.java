import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * 
 * @author phamacher
 *
 */
public abstract class GameObject implements Renderable {
	
	protected CollisionBox collisionBox;
	private Vector2f velocity;
	private Vector2f acceleration;
	
	public GameObject(Position pos, Position size)
	{
		this.collisionBox = new CollisionBox(pos, size, this);
		velocity = new Vector2f();
		acceleration = new Vector2f();
	}
	/**
	 * updates the GameObject
	 * @param delta Time in milliseconds since last update
	 */
	public void update(int delta){
		velocity = velocity.add(acceleration);
		acceleration = new Vector2f();
		Position p = collisionBox.getPosition();
		//TODO: Position with floats???
		collisionBox.update(new Position(Math.round(p.getX() + velocity.x), Math.round(p.getY() + velocity.y)));
		velocity = new Vector2f(velocity.x * (1 - getFriction()), velocity.y * (1 - getFriction()));
	}
	
	public abstract float getFriction();
	
	public void accelerate(Vector2f acceleration)
	{
		acceleration = this.acceleration.add(acceleration);
	}
	
	/**
	 * returns the Position of the GameObject
	 */
	@Override
	public Position getPosition()
	{
		return collisionBox.getPosition();
	}
}

