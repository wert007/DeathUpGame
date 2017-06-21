/**
 * 
 * @author jherrmann
 *
 */
public class Position {
	int x;
	int y;
	
	/**
	 * Creates a new Position
	 * @param x x-value
	 * @param y y-value
	 */
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;	
	}
	
	public int getY(){
		return this.y;	
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
}

