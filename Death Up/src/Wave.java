import java.util.ArrayList;
import java.util.Arrays;


public class Wave {

	private int targetCountEnemies;
	private float spawnedCountEnemies;
	private ArrayList<Enemy> enemies;
	private final int SECONDSTOSPAWN = 5;
	
	/**
	 * Creates a new Wave
	 * @param targetCountEnemies Enemies to Spawn
	 */
	public Wave(int targetCountEnemies)
	{
		this.targetCountEnemies = targetCountEnemies;
		spawnedCountEnemies = 0;
		enemies = new ArrayList<Enemy>();
	}
	/**
	 * updates the wave
	 * @param delta milliseconds since last update call
	 * @param player Target of the enemies
	 */
	public void update(int delta, Player player)
	{
		float spawnThisUpdate = (targetCountEnemies - spawnedCountEnemies) / SECONDSTOSPAWN * delta / 1000.0f; // spawns pro frame
		spawnedCountEnemies+= spawnThisUpdate;
		for (int i = 0; i < spawnedCountEnemies - enemies.size(); i++) {
			enemies.add(new Enemy(AStar.GetInstance().getRdmSpawn()));
		}
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update(player, delta);
		}
	}
	
	/**
	 * Returns all living enemies current in game
	 * @return All enemies alive
	 */
	public Enemy[] getEnemies()
	{
		//TODO Really?
		return Arrays.copyOf(enemies.toArray(), enemies.size(), Enemy[].class); //(Enemy[])enemies.toArray();
	}
	
}
