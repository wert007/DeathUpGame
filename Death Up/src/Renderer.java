import java.util.ArrayList;
import java.util.Collections;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * 
 * @author phamacher
 *
 */
public class Renderer{
	private Map map;
	private ArrayList<PositionableImage> textures;
	private Position pos;
	private Vector2f velocity;
	private Vector2f acceleration;
	private final int SPEED = 250;
	
	
	/**
	 * Creates a Renderer for the game
	 * @param map Root of all renderable things
	 */
	public Renderer(Map map)
	{
		
		this.map = map;
		ArrayList<Renderable> renderables = new ArrayList<Renderable>();
		renderables.add(map);
		for(Renderable r : map.getChildren())
		{
			renderables.add(r);
		}
		
		try {
			reloadTextures(renderables);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.pos= new Position(0,0);
		velocity = new Vector2f();
		acceleration = new Vector2f();
	}
	
	public Position getPos(){
		return this.pos;
	}
	
	public void Up(int delta){
		acceleration = this.acceleration.add(new Vector2f(0, SPEED * delta / 1000.0f));
		
	}
	
	public void Down(int delta){
		acceleration = this.acceleration.add(new Vector2f(0, -SPEED * delta / 1000.0f));
	}

	public void Left(int delta){
		acceleration = this.acceleration.add(new Vector2f(SPEED * delta / 1000.0f, 0));
	}
	
	public void Right(int delta){
		acceleration = this.acceleration.add(new Vector2f(-SPEED * delta / 1000.0f, 0));
	}
	
	public void reloadTextures() throws SlickException
	{
		ArrayList<Renderable> renderables = new ArrayList<Renderable>();
		renderables.add(map);
		for(Renderable r : map.getChildren())
		{
			renderables.add(r);
		}
		reloadTextures(renderables);
	}
	
	/**
	 * Updates the Textures
	 * @throws SlickException 
	 */
	public void reloadTextures(ArrayList<Renderable> renderables) throws SlickException
	{
		textures = new ArrayList<PositionableImage>();
		for(Renderable r : renderables)
		{
			textures.add(new PositionableImage(new Image(r.getPath()), r));
		}
		sortTextures();
	}
	
	private void sortTextures()
	{
		Collections.sort(textures);
		Collections.reverse(textures);
	}
	
	/**
	 * Render game
	 * @param g Graphics
	 */
	public void render(Graphics g)
	{
		velocity = velocity.add(acceleration);
		acceleration = new Vector2f();
		//TODO: Position with floats???
		pos = new Position(Math.round(pos.getX() + velocity.x), Math.round(pos.getY() + velocity.y));
		velocity = new Vector2f(velocity.x * (1 - map.getPlayer().getFriction()), velocity.y * (1 - map.getPlayer().getFriction()));
		for(int i = 0; i < textures.size(); i++)
		{
			textures.get(i).draw(pos);			
		}
		
	}
}
