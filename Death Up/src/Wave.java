import java.util.ArrayList;
import java.util.Arrays;


public class Wave {

	private int targetCountEnemies;
	private float spawnedCountEnemies;
	private float oldSpawn;
	private ArrayList<Enemy> enemies;
	private final float SECONDSTOSPAWN = 0.1f;
	private Player player;
	
	/**
	 * Creates a new Wave
	 * @param targetCountEnemies Enemies to Spawn
	 */
	public Wave(int targetCountEnemies, Player player)
	{
		this.targetCountEnemies = targetCountEnemies;
		spawnedCountEnemies = 0;
		oldSpawn = 0;
		this.player = player;
		enemies = new ArrayList<Enemy>();
	}
	/**
	 * updates the wave
	 * @param delta milliseconds since last update call
	 * @param player Target of the enemies
	 */
	public boolean update(int delta)
	{
		float spawnThisUpdate =oldSpawn + (targetCountEnemies - spawnedCountEnemies) / SECONDSTOSPAWN * delta / 1000.0f; // spawns pro frame
		//System.out.println((int)spawnThisUpdate);
		spawnedCountEnemies+= (int)spawnThisUpdate;
		
		for (int i = 0; i < (int)spawnThisUpdate; i++) {
			enemies.add(new Enemy(AStar.GetInstance().getRdmSpawn(), this, (100 - targetCountEnemies) / 10.0f + 3));
		}
		oldSpawn = (int)spawnThisUpdate - spawnThisUpdate;
		for (int i = enemies.size() - 1; i >= 0; i--) {
			if(enemies.get(i).update(player, delta))
			{
				return true;
			}
		}
		return false;
	}
	
	public void enemyKilled(Enemy enemy)
	{
		player.higherScore(100);
		enemies.remove(enemy);
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
