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
	 * Gives you the x-position in percent of the center of rotation.
	 * @return the x-position in percent of the center of rotation
	 */
	public float getCenterOfRotationX();
	/**
	 * Gives you the y-position in percent of the center of rotation.
	 * @return the y-position in percent of the center of rotation
	 */
	public float getCenterOfRotationY();
	/**
	 * Gives you the rotation of the texture in radian measure
	 * @return Rotation in radian measure
	 */
	public float getRotation();
	
	/**
	 * Returns true if it doesn't move with the camera.
	 * @return
	 */
	public boolean isCameraRelated();
	
	
}
