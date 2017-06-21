import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Music;
import org.newdawn.slick.MusicListener;
import org.newdawn.slick.SlickException;


public class MusicPlayer implements MusicListener {

	private boolean isPlaying;
	private ArrayList<Music> tracks;
	private int currentTrack;
	
	/**
	 * Creates MusicPlayer to play music of the map
	 * @param map To Get the music of the Map
	 */
	public MusicPlayer(Map map)
	{
		currentTrack = -1;
		
		tracks = new ArrayList<Music>();
		File folder = new  File("/sfx");
		File[] listOfFiles = folder.listFiles();
		for(File file : listOfFiles){
			if(file.isFile())
			{
				Music track = null;
				try {
					track = new Music(file.getAbsolutePath());
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(track != null)
					tracks.add(track);
			}
		}
	}
	
	
	/**
	 * Starts playing ambient background music
	 */
	public void play()
	{
		Random rdm = new Random();
		currentTrack =  rdm.nextInt(tracks.size());
		tracks.get(currentTrack).play();
	}
	
	/**
	 * stops the ambient background music
	 */
	public void stop()
	{
		
	}
	
	/**
	 * One of the tracks has ended.
	 * @param m Track that ended.
	 */
	@Override
	public void musicEnded(Music m) {
		// TODO Auto-generated method stub
	}

	/**
	 * Switched the tracks
	 * @param oldM Track that played before
	 * @param newM Track now playing
	 */
	@Override
	public void musicSwapped(Music oldM, Music newM) {
		// TODO Auto-generated method stub
		
	}

}
