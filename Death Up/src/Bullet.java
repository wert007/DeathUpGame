import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * 
 * @author phamacher
 *
 */
public class Bullet extends GameObject {
	private float direction;
	private final float SPEED = 20;
	
	/**
	 * Create a new Bullet
	 * @param pos Position to spawn bullet
	 */
	public Bullet(Position pos, float direction)
	{
		super(pos, new Position(10, 10));
		this.direction = direction;
		accelerate(new Vector2f((float)Math.cos(direction), (float)Math.sin(direction)).scale(SPEED));
	}
	/**
	 * Updates the bullet
	 * 
	 * @return Hit something??
	 */
	public boolean updateBullet(int delta){
		super.update(delta);
		for(CollisionBox c : collisionBox.collideWith())
		{
			if(c.getParent() instanceof Enemy)
				return true;
			if(c.getParent() instanceof Obstacle)
				return true;
			if(c.getParent() instanceof Bullet) //Would be so awesome!
				return true;
		}
		return false;
	}

	@Override
	public String getPath() {
		return "./gfx/bullet.png";
	}

	@Override
	public int getZ() {
		return 90;
	}
	@Override
	public float getFriction() {
		return 0;
	}
	@Override
	public float getRotation() {
		return direction;
	}
	
}
