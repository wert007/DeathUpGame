import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.Image;

/**
 * 
 * @author jherrmann
 *
 */
public class Weapon implements Renderable {
	
	private ArrayList<Bullet> bullets;
	private Player player;
	private final int cooldown = 7;
	private int pause;
	
	/**
	 * Creates a new Weapon
	 * @param player Owner of the Weapon
	 */
	public Weapon(Player player)
	{
		this.bullets=new ArrayList<Bullet>();
		this.player=player;
		pause = cooldown;
	}
	
	/**
	 * Shoots the weapon and fires a bullet
	 * 
	 * @param direction Direction in 2 * PI
	 */
	public void shoot(float direction) {
		if(pause != 0) return;
		bullets.add(new Bullet(player.getPosition(),direction));
		pause = cooldown;
	}
	
	/**
	 * Removes a Bullet
	 * 
	 * @param bullet Bullet to Remove
	 */
	public void removeBullet(Bullet bullet)
	{
		
	}
	
	/**
	 * Updates the Weapon and its bullets
	 * @param delta Time since last Frame in Milliseconds
	 */
	public void update(int delta)
	{
		pause = Math.max(0, pause - 1);
		for(int i = 0; i < bullets.size(); i++)
		{
			boolean shoot = bullets.get(i).updateBullet(delta);
			if(shoot)
			{
				//bullets.get(i).killInstance();
				bullets.remove(i);
			}
		}
	}
	
	/**
	 * Returns all moving bullets in game
	 * @return All moving bullets
	 */
	public Bullet[] getBullets()
	{
		return Arrays.copyOf(bullets.toArray(), bullets.size(), Bullet[].class);
		//return (Bullet[])bullets.toArray();
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return "./gfx/weapon.png";
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 1000;
	}

	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return player.getPosition();
	}

	@Override
	public float getRotation() {
		// TODO Auto-generated method stub
		return player.getRotation();
	}

	@Override
	public float getCenterOfRotationX() {
		// TODO Auto-generated method stub
		return 0.25f;
	}

	@Override
	public float getCenterOfRotationY() {
		// TODO Auto-generated method stub
		return 0.5f;
	}

	@Override
	public boolean isCameraRelated() {
		// TODO Auto-generated method stub
		return true;
	}
}
