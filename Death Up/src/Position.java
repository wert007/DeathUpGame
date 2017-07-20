/**
 * 
 * @author jherrmann
 *
 */
public class Position {
	float x;
	float y;
	
	/**
	 * Creates a new Position
	 * @param x x-value
	 * @param y y-value
	 */
	public Position(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public float getX(){
		return x;	
	}
	
	public float getY(){
		return y;	
	}
	
	public int getXInt(){
		return Math.round(x);	
	}
	
	public int getYInt(){
		return Math.round(y);	
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public float distance(Position position){
		return (float) Math.sqrt(Math.pow(this.x - position.getX(), 2) + Math.pow(this.y - position.getY(), 2));
	}
}

