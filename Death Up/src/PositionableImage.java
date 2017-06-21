import org.newdawn.slick.Image;


public class PositionableImage extends Image implements Comparable {
	Renderable parent;
	
	public PositionableImage(Image image, Renderable parent)
	{
		super(image);
		this.parent = parent;
	}
	
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
