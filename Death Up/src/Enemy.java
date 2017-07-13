import org.newdawn.slick.geom.Vector2f;

/**
 * 
 * @author phamacher
 *
 */
public class Enemy extends GameObject{
	private Node current;
	private final float SPEED = 5; //Pixels per Second
	private float rotation;
	
	/**
	 * Creates an Enemy at a specific Position (Node).
	 * @param position Node where the Enemy stands on
	 */
	public Enemy(Node position) {
		super(position.getPosition(), new Position(32, 32));
		// TODO Auto-generated constructor stub
		current = position;
		rotation = 0;
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
		//TODO implement findPath in Astar
		current = AStar.GetInstance().findPath(current, player.getPlayerNode());
		int xDif = current.getPosition().getX() - getPosition().getX();
		int yDif = current.getPosition().getY() - getPosition().getY();
		Vector2f dif =new Vector2f(xDif, yDif).normalise().scale(SPEED * delta / 1000.0f);
		rotation = (float)Math.atan2(yDif, xDif);
		accelerate(dif);
	}

	@Override
	public String getPath() {
		return "./gfx/enemy.png";
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
