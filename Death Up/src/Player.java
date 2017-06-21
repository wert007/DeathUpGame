import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * 
 * @author phamacher
 *
 */
public class Player extends GameObject {
	private float health;
	private Weapon weapon;
	private float direction;
	private Node node;
	/**
	 * Pixels per second
	 */
	private final float SPEED = 250; //Pixels per second

	
	/**
	 * Creates a new Player
	 * @param pos Position of the Player
	 * @param health Health of the Player
	 */
	public Player(Position pos, float health)
	{
		super(pos, new Position(64, 64));
		health = 5;
		weapon = new Weapon(this);
		direction = 0f;
		node = new Node(pos, 1);
	}
	/**
	 * The player walks up
	 * 
	 * @param delta Time since last Update in milliseconds
	 */
	public void walkNorth(int delta)
	{
		accelerate(new Vector2f(0, -SPEED * delta / 1000.0f));
	}

	/**
	 * The player walks left
	 * @param delta Time since last Update in milliseconds
	 */
	public void walkWest(int delta)
	{
		accelerate(new Vector2f(-SPEED * delta / 1000.0f, 0));
	}
	
	/**
	 * The player walks right
	 * @param delta Time since last Update in milliseconds
	 */
	public void walkEast(int delta)
	{
		accelerate(new Vector2f(SPEED * delta / 1000.0f, 0));
	}
	
	/**
	 * The player walks down
	 * @param delta Time since last Update in milliseconds
	 */
	public void walkSouth(int delta)
	{
		accelerate(new Vector2f(0, SPEED * delta / 1000.0f));
	}
	
	public void setRotation(float rotation)
	{
		direction = rotation;
	}
	
	/** 
	 * Get called when you want to shoot.
	 */
	public void shoot()
	{
		weapon.shoot(direction);
	}
	
	/**
	 * Jim is dead. The Player.. The Game is over.
	 */
	public void die() 
	{
		
	}
	
	public void setDirection(int mouseX, int mouseY)
	{
	
		this.direction = new Float((Math.atan2(mouseY, mouseX) ));//+ 2 * Math.PI) % (2 * Math.PI));
		System.out.println(direction * 180 / Math.PI);
	}
	
	public Node getPlayerNode()
	{
		return node;
	}
	
	public Weapon getWeapon()
	{
		return weapon;
	}
	/**
	 * Runs the update cycle
	 * @param delta Time since last Update in milliseconds
	 */
	public void update(int delta)
	{
		super.update(delta);
	}

	@Override
	public String getPath() {
		return  "./gfx/player.png";
	}

	@Override
	public int getZ() {
		return 100;
	}
	@Override
	public float getFriction() {
		// TODO Auto-generated method stub
		return 0.1f;
	}
	@Override
	public float getRotation() {
		// TODO Auto-generated method stub
		return direction;
	}
}
