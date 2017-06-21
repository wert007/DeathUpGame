import org.newdawn.slick.geom.Vector2f;

/**
 * 
 * @author phamacher
 *
 */
public class Enemy extends GameObject{
	private Node current;
	private final float SPEED = 5; //Pixels per Second
	private Float rotation;
	
	public Enemy(Node position) {
		super(position.getPosition(), new Position(32, 32));
		// TODO Auto-generated constructor stub
	}

	/**
	 * The Enemy Attacks the Player
	 */
	public void attack()
	{
		
	}
	
	/**
	 * tells the Enemy, where to go
	 * @param player the position of the Player
	 */
	public void update(Player player, int delta)
	{
		current = AStar.GetInstance().findPath(current, player.getPlayerNode());
		int xDif = current.getPosition().getX() - getPosition().getX();
		int yDif = current.getPosition().getY() - getPosition().getY();
		Vector2f dif =new Vector2f(xDif, yDif).normalise().scale(SPEED * delta / 1000.0f);
		rotation = (float)Math.atan2(yDif, xDif);
		accelerate(dif);
	}

	@Override
	public String getPath() {
		return "./gfx/basicenemy.png";
	}

	@Override
	public int getZ() {
		return 80;
	}

	@Override
	public float getFriction() {
		// TODO Auto-generated method stub
		return 0.5f;
	}

	@Override
	public float getRotation() {
		// TODO Auto-generated method stub
		return rotation;
	}
	
}
