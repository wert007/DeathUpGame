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
	private Player player;
	
	
	/**
	 * Creates a Renderer for the game
	 * @param map Root of all renderable things
	 */
	public Renderer(Map map)
	{
		
		player = map.getPlayer();
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
	}
	
	public Position getPos(){
		return this.pos;
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
			textures.add(new PositionableImage(new Image("./src/" + r.getPath()), r));
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
		for(int i = 0; i < textures.size(); i++)
		{
		
			textures.get(i).draw(pos);			
		}
		
	}
	public void update(int delta) throws SlickException{
		reloadTextures();
		this.getPos().setX(-this.player.getPosition().getX() + 640);
		this.getPos().setY(-this.player.getPosition().getY() + 360);
	}
}
