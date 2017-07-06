import java.util.Random;

import org.newdawn.slick.Image;

/**
 * 
 * @author phamacher
 *
 */
public class PoolOfBlood implements Renderable {
	private Position position;
	private static Random rand = new Random();
	/**
	 * Creates a new PoolOfBlood
	 * @param position Position of the PoolOfBlood
	 */
	public PoolOfBlood(Position position)
	{
		this.position = position;
	}
	
	@Override
	public String getPath() {
		//TODO: Replace 10 with the actual count of files in PoolOfBloods
		return "./gfx/PoolOfBloods/" + rand.nextInt(10) + ".png";
	}
	@Override
	public int getZ() {
		return 10;
	}
	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public float getRotation() {
		// TODO Auto-generated method stub
		return 0f;
	}

	@Override
	public float getCenterOfRotationX() {
		// TODO Auto-generated method stub
		return 0.5f;
	}

	@Override
	public float getCenterOfRotationY() {
		// TODO Auto-generated method stub
		return 0.5f;
	}
}
