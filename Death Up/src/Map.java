import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

/**
 * 
 * @author jherrmann
 *
 */
public class Map implements Renderable {
	private int score;
	private String name;
	private Image texture;
	private int width;
	private int height;
	private Wave wave;
	private ArrayList<PoolOfBlood> poolOfBloods;
	private ArrayList<Obstacle> obstacles;
	private Player player;
	private static Random rand = new Random();
	private Position pos; 
	/**
	 * Creates new Map
	 * @param name Name of the Map
	 * @param width Width of the Map
	 * @param height Height of the Map
	 */
	public Map(String name, int width, int height)
	{
		this.name = name;
		this.width = width;
		this.height = height;
		this.pos= new Position((int) (640-0.5*this.width),(int) (360-0.5*this.height));
		this.score = 0;
		this.player = new Player(new Position((int) (0.5 * 1280),(int) (0.5 * 720)), 100);
		this.obstacles= new ArrayList<Obstacle>();
		for(int i=0; i<0; i++){
			this.obstacles.add(new Obstacle(new Position(rand.nextInt(this.width),rand.nextInt(this.height)),new Position(20,20)));
			}
		this.poolOfBloods= new ArrayList<PoolOfBlood>();
		this.wave= new Wave(10);
		}
	
	/**
	 * Spawns an enemy at a specific position
	 * @param position to spawn the enemy
	 */
	public int getWidth(){
	return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public void spawnEnemy(Position position){
		
	}
	
	/**
	 * Removes a specific enemy
	 * @param enemy to remove
	 */
	public void removeEnemy(Enemy enemy){
		
	}
	
	/**
	 * updates Map
	 * @param GameContainer container holding the game
	 * @param delta Time in milliseconds since last update
	 */
	public void update(GameContainer container, int delta){
		player.update(delta);
		wave.update(delta, this.player);
		
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public Renderable[] getChildren()
	{
		ArrayList<Renderable> result = new ArrayList<Renderable>();
		result.add(this);
		result.add(player);
		result.add(player.getWeapon());
		result.addAll(Arrays.asList(player.getWeapon().getBullets()));
		result.addAll(poolOfBloods);
		result.addAll(obstacles);
		result.addAll(Arrays.asList(wave.getEnemies()));
		System.out.println(result.size());
		return Arrays.copyOf(result.toArray(), result.size(), Renderable[].class);//(Renderable[])(result.toArray());
	}
	
	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return "./gfx/map.png";
	}
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return this.pos;
	}

	@Override
	public float getRotation() {
		// TODO Auto-generated method stub
		return 0f;
	}

	
}
