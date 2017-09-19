package AppPackage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MainClass {
	FileInputStream FIS;
	BufferedInputStream BIS;
	
	public long pauseLocation;
	public long songtotalLength;
	public String fileLocation;
	
	public Player player;
	
	public void Stop(){
		if(player != null) {
			player.close();
			pauseLocation = 0;
			songtotalLength = 0; 
		}
	}
	
	public void Resume(){
		try {
			FIS = new FileInputStream(fileLocation);
			BIS = new BufferedInputStream(FIS);
			player = new Player(BIS);
			FIS.skip(songtotalLength - pauseLocation);
		} catch (FileNotFoundException | JavaLayerException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	new Thread(){
		public void run(){
			try {
				player.play();
			}
			catch (JavaLayerException ex) {
				
			}
		}
	}.start();
	
	
	}
	
	
	public void Play(String path){
		try {
			FIS = new FileInputStream(path);
			BIS = new BufferedInputStream(FIS);
			player = new Player(BIS);
			songtotalLength = FIS.available();
			fileLocation = path + "";
		} catch (FileNotFoundException | JavaLayerException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	new Thread(){
		public void run(){
			try {
				player.play();
			}
			catch (JavaLayerException ex) {
				
			}
		}
	}.start();
	
	
	}
	public void Pause() {
		if(player != null) {
			try {
				pauseLocation = FIS.available();
			} catch (IOException e) {
			}
			player.close();
		}
	}
}
