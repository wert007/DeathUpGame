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
	
	
	/**
	 * 
	 * @param title Windowtitle
	 */
	
	
	public DeathUpGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Renders the whole monitor
	 * 
	 * @param gc GameContainer
	 * @param g The Graphics to draw
	 */
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.draw(new Ellipse(30f, 30f, 40f, 60f));
	}

	/**
	 * initializes the game, load static recources
	 * 
	 * @param gc GameContainer
	 */
	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
	}

	/**
	 * updates game logic
	 * 
	 * @param gc GameContainer
	 * @param delta time since last uopdate
	 */
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer deathUp = new AppGameContainer(new DeathUpGame("Death Up"));
		deathUp.setDisplayMode(256, 256, false);
		deathUp.setVSync(true);
		deathUp.setShowFPS(true);
		deathUp.start();
	}

}
