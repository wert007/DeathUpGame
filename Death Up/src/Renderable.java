/**
 * 
 * @author phamacher
 *
 */
public interface Renderable {
	/**
	 * Gives you the path of an image.
	 * @return The path of the image
	 */
	public String getPath();
	/**
	 * Gives you the order (Z-Coordinate), in which your textures are drawn. Higher numbers will be first drawn.
	 * @return Z-Coordinate
	 */
	public int getZ();
	/**
	 * Gives you the position of the texture in pixels.
	 * @return Position in pixels
	 */
	public Position getPosition();
	/**
	 * Gives you the rotation of the texture in radian measure
	 * @return Rotation in radian measure
	 */
	public float getRotation();
}
