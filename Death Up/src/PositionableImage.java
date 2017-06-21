import org.newdawn.slick.Image;

/**
 * 
 * @author phamacher
 *
 */
public class PositionableImage extends Image implements Comparable {
	Renderable parent;
	
	/**
	 * Creates an PositionableImage
	 * @param image The image this based on
	 * @param parent Parent of this to update data
	 */
	public PositionableImage(Image image, Renderable parent)
	{
		super(image);
		this.parent = parent;
	}
	
	/**
	 * Draws the image with the offset of the camera
	 * @param offset Offset because of the moving camera
	 */
	public void draw(Position offset)
	{
		setRotation((float) (parent.getRotation() * 180 / Math.PI));
		draw(parent.getPosition().getX() + offset.getX(), parent.getPosition().getY() + offset.getY());
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof PositionableImage)
		{
			return ((PositionableImage) o).parent.getZ() - parent.getZ(); //Maybe the otherway round
		}
		return 0;
	}
}
