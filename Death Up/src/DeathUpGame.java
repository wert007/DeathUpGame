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
	private int state = 1;
	
	
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
		if(state != 1)
			{
			g.drawString("GAME OVER", gc.getWidth() / 2 - 50, gc.getHeight() / 2 - 20);
			return;
			}
		renderer.render(g);
		g.drawString("Score: " + map.getPlayer().getScore(), 10, 30);
	}

	/**
	 * initializes the game, load static resources
	 * 
	 * @param gc GameContainer contains the informations of the game
	 */
	@Override
	public void init(GameContainer gc) throws SlickException {
		map = new Map("Arena", 700 * 2, 524 * 2, this);
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
		if(state != 1) return;
		// TODO Auto-generated method stub
	//	System.out.println("X: " + map.getPlayer().getPosition().getX() + " Y: " + map.getPlayer().getPosition().getY());
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) //example
		{
			//renderer.Up(delta);
		//	if(map.getPlayer().getPosition().getY() > 0){
			map.getPlayer().walkNorth(delta);
		//	}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) //example
		{	
			//renderer.Left(delta);
		//	if(map.getPlayer().getPosition().getX() > 0){	
			map.getPlayer().walkWest(delta);
			//}
			
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) //example
		{
			//renderer.Down(delta);
		//	if(map.getPlayer().getPosition().getY() < 2160){
			map.getPlayer().walkSouth(delta);
		//	}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) //example
		{
			//renderer.Right(delta);
			//if(map.getPlayer().getPosition().getX() > 3840){
			map.getPlayer().walkEast(delta);
		//	}
		}
		float debugrot = (float)Math.atan2(Mouse.getY() - 524, Mouse.getX() - 700);
		map.getPlayer().setDirection(Mouse.getX() - gc.getWidth() / 2, -Mouse.getY() + gc.getHeight() / 2);
		//System.out.println(map.getPlayer().getRotation()+ "");
		if(map.update(gc, delta))
			return;
		renderer.update(delta);
		if(Mouse.isButtonDown(0)) //LeftButton
		{
			map.getPlayer().shoot();
			renderer.reloadTextures();
		}
		if(Mouse.isButtonDown(1))
		{
			System.out.println("1");
		}
		if(Mouse.isButtonDown(2))
		{
			System.out.println("2");
		}
		if(Mouse.isButtonDown(3))
		{
			System.out.println("3");
		}
	}
	
	public void endGame()
	{
		state = 2;
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer deathUp = new AppGameContainer(new DeathUpGame("Death Up"));
		deathUp.setDisplayMode(1280, 720, false);
		deathUp.setVSync(true);
		deathUp.setShowFPS(true);
		deathUp.start();
	}

}
