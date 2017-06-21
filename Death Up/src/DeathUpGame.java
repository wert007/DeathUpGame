import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;

/**
 * 
 */

/**
 * @author phamacher
 *
 */
public class DeathUpGame extends BasicGame {
	
	private Map map;
	private Renderer renderer;
	
	
	/**
	 * Creates the Game
	 * @param title Windowtitle
	 */
	public DeathUpGame(String title) {
		super(title);
	}

	/**
	 * Renders the whole monitor
	 * 
	 * @param gc GameContainer contains the informations of the game
	 * @param g Graphics to draw
	 */
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		renderer.render(g);
//		return;
		g.draw(new Ellipse(Mouse.getX() - gc.getWidth() / 2, Mouse.getY() - gc.getHeight() /  2, 40f, 60f));
		g.draw(new org.newdawn.slick.geom.Rectangle(130, 130, 32, 32));
		g.draw(new org.newdawn.slick.geom.Rectangle(130, 230, 64, 64));
		g.draw(new org.newdawn.slick.geom.Rectangle(130, 330, 48, 48));
		g.draw(new org.newdawn.slick.geom.Rectangle(230, 330, 80, 80));
		g.draw(new org.newdawn.slick.geom.Rectangle(330, 330, 48, 96));
	}

	/**
	 * initializes the game, load static resources
	 * 
	 * @param gc GameContainer contains the informations of the game
	 */
	@Override
	public void init(GameContainer gc) throws SlickException {
		map = new Map("Arena", 700 * 2, 524 * 2);
		renderer = new Renderer(map);
	}

	/**
	 * updates game logic and handles player input
	 * 
	 * @param gc GameContainer contains the informations of the game
	 * @param delta time since last update
	 */
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) //example
		{
			
			renderer.Up(delta);
			
			map.getPlayer().walkNorth(delta);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) //example
		{
			if(renderer.getPos().getX() < map.getPosition().getX()){
				renderer.Left(delta);
				}
			map.getPlayer().walkWest(delta);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) //example
		{
			renderer.Down(delta);
			map.getPlayer().walkSouth(delta);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) //example
		{
			renderer.Right(delta);
			map.getPlayer().walkEast(delta);
		}
		float debugrot = (float)Math.atan2(Mouse.getY() - 524, Mouse.getX() - 700);
		map.getPlayer().setDirection(Mouse.getX() - gc.getWidth() / 2, -Mouse.getY() + gc.getHeight() / 2);
		//System.out.println(map.getPlayer().getRotation()+ "");
		map.update(gc, delta);
		
	}
	
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer deathUp = new AppGameContainer(new DeathUpGame("Death Up"));
		deathUp.setDisplayMode(1280, 720, false);
		deathUp.setVSync(true);
		deathUp.setShowFPS(true);
		deathUp.start();
	}

}
