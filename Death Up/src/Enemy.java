import org.newdawn.slick.geom.Vector2f;

/**
 * 
 * @author phamacher
 *
 */
public class Enemy extends GameObject{
	private Node current;
	private Wave parent;
	private float SPEED = 6f; //Pixels per Second
	private float rotation;
	
	/**
	 * Creates an Enemy at a specific Position (Node).
	 * @param position Node where the Enemy stands on
	 */
	public Enemy(Node position, Wave parent, float SPEED) {
		super(position.getPosition(), new Position(32, 32));
		// TODO Auto-generated constructor stub
		current = position;
		rotation = 0;
		this.SPEED = SPEED;
		this.parent = parent;
	}

	/**
	 * The Enemy Attacks the Player
	 */
	public void attack()
	{
		
	}
	
	 @Override
	public void killInstance() {
		super.killInstance();
		parent.enemyKilled(this);
	}
	
	 /**
	 * tells the Enemy, where to go
	 * @param player the position of the Player
	 */
	public boolean update(Player player, int delta)
	{
		super.update(delta);
		//TODO implement findPath in Astar
		
		//current = AStar.GetInstance().findPath(current, player.getPlayerNode());
		float xDif = player.getPosition().getX() - getPosition().getX();
		float yDif = player.getPosition().getY() - getPosition().getY();
		Vector2f dif =new Vector2f(xDif, yDif);
		if(dif.lengthSquared() < 600)
		{
			player.die();
			return true;
		}
		Vector2f dir = dif.normalise().scale(SPEED);
		//System.out.println(dif);
		rotation = (float)Math.atan2(yDif, xDif);
		accelerate(dir);
		return false;
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
		return 1f;
	}

	@Override
	public float getRotation() {
		// TODO Auto-generated method stub
		return rotation;
	}

	@Override
	public boolean isCameraRelated() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
